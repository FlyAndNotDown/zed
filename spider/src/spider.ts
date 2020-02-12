import { config } from "./config";
import * as Cheerio from 'cheerio';
import { Log } from "./log";
import { default as Axios } from "axios";
import * as FileSystem from 'fs';
import * as Path from 'path';
import * as ExcelDealer from 'node-xlsx';

export interface API {
    name: string,
    levelAdded: string,
    levelDeprecated: string,
    prototype: string
}

export interface ApiExcelSheet {
    name: string,
    data: string[][]
}

export class Spider {
    private static async getSourceFromUrl(url: string): Promise<string> {
        let response = null;
        try {
            response = await Axios.get(url, {});
        } catch (e) {
            Log.log('err', "network error");
        }
        if (response == null || response.data == null) {
            return "";
        }
        return response.data;
    }

    private static getApiPrototype($: CheerioStatic, context: CheerioElement): string {
        let apiPrototype: string = '';
        $('pre.api-signature', context).each(function () {
            apiPrototype += $(this).text();
        });
        return apiPrototype
            .replace(/\n/g, ' ')
            .replace(/ +/g, ' ')
            .replace(/ \(/g, '(');
    }

    private static getApis(source: string): API[] {
        const apis: API[] = [];
        const $: CheerioStatic = Cheerio.load(source);
        let apiCount: number = 0;
        $('div[data-version-added]').each(function (index, context) {
            apis.push({
                name: $('h3.api-name', context).text(),
                levelAdded: $(context).attr('data-version-added'),
                levelDeprecated: $(context).attr('data-version-deprecated') || '0',
                prototype: Spider.getApiPrototype($, context)
            });
            apiCount++;
        });
        Log.log('info', `found total ${apiCount} apis`);
        return apis;
    }

    private static checkAndMkdir(path: string): void {
        const parent: string = Path.resolve(path, '..');
        if (!FileSystem.existsSync(parent)) {
            Spider.checkAndMkdir(parent);
        }
        if (!FileSystem.existsSync(path)) {
            FileSystem.mkdirSync(path);
        }
    }

    private static parseApisToExcelSheet(apis: API[], name: string): ApiExcelSheet {
        const title: string[] = [
            'Name', 'LevelAdded', 'LevelDeprecated', 'Prototype'
        ];
        let rows: string[][] = [title];

        apis.forEach(api => {
            rows.push([
                api.name,
                api.levelAdded,
                api.levelDeprecated,
                api.prototype
            ]);
        });

        return {
            name: name,
            data: rows
        };
    }

    private static save(file: string, apiExcelSheets: ApiExcelSheet[]): void {
        Spider.checkAndMkdir(Path.resolve(file, '..'));
        if (FileSystem.existsSync(file)) {
            FileSystem.unlinkSync(file);
        }
        FileSystem.writeFileSync(file, ExcelDealer.build(apiExcelSheets), 'binary');
    }

    public static async fetchActivityApis(): Promise<void> {
        const source: string = await Spider.getSourceFromUrl(config.url.activity);
        const splitTemp: string[] = source.split('<!-- ========= METHOD DETAIL ======== -->');
        const publicMethodSource: string = splitTemp[1];
        const protectedMethodSource: string = splitTemp[2].split('<!-- ========= END OF CLASS DATA ========= -->')[0];

        Log.log('info', 'starting fetch activity public apis');
        const publicApis: API[] = Spider.getApis(publicMethodSource);
        const publicApiExcelSheet: ApiExcelSheet = Spider.parseApisToExcelSheet(publicApis, 'public');

        Log.log('info', 'starting fetch activity protected apis');
        const protectedApis: API[] = Spider.getApis(protectedMethodSource);
        const protectedApiExcelSheet: ApiExcelSheet = Spider.parseApisToExcelSheet(protectedApis, 'protected');

        const savePath: string = Path.resolve(config.save, 'activity', 'apis.xlsx');
        Log.log('info', `saved apis to ${savePath}`);
        Spider.save(savePath, [publicApiExcelSheet, protectedApiExcelSheet]);
    }
}