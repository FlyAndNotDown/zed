import { config } from "./config";
import * as Cheerio from 'cheerio';
import { Log } from "./log";
import { default as Axios } from "axios";
import * as FileSystem from 'fs';
import * as Path from 'path';

export interface API {
    name: string,
    levelAdded: number,
    levelDeprecated: number
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

    private static getApis(source: string): API[] {
        const apis: API[] = [];
        const $: CheerioStatic = Cheerio.load(source);
        let apiCount: number = 0;
        $('div[data-version-added]').each(function () {
            apis.push({
                name: $('h3.api-name', this).text(),
                levelAdded: parseInt($(this).attr('data-version-added')),
                levelDeprecated: parseInt($(this).attr('data-version-deprecated')) || 0
            });
            apiCount++;
        });
        Log.log('info', `found total ${apiCount} apis`);
        return apis;
    }

    private static parseApisObjectToText(apis: API[]): string {
        const result: string = '';
        apis.forEach(api => {
            // TODO
        });
        return result;
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

    private static save(file: string, content: string): void {
        Spider.checkAndMkdir(Path.resolve(file, '..'));
        if (FileSystem.existsSync(file)) {
            FileSystem.unlinkSync(file);
        }
        FileSystem.writeFileSync(file, content);
    }

    public static async fetchActivityApis(): Promise<void> {
        const source: string = await Spider.getSourceFromUrl(config.url.activity);
        const splitTemp: string[] = source.split('<!-- ========= METHOD DETAIL ======== -->');
        const publicMethodSource: string = splitTemp[1];
        const protectedMethodSource: string = splitTemp[2].split('<!-- ========= END OF CLASS DATA ========= -->')[0];

        Log.log('info', 'starting fetch activity public apis');
        const publicApis: API[] = Spider.getApis(publicMethodSource);
        const publicApisSavePath: string = Path.resolve(config.save, 'activity', 'public.txt');
        Log.log('info', `saved apis to ${publicApisSavePath}`);
        Spider.save(publicApisSavePath, Spider.parseApisObjectToText(publicApis));

        Log.log('info', 'starting fetch activity protected apis');
        const protectedApis: API[] = Spider.getApis(protectedMethodSource);
        const protectedSavePath: string = Path.resolve(config.save, 'activity', 'protected.txt');
        Log.log('info', `saved apis to ${protectedSavePath}`);
        Spider.save(protectedSavePath, Spider.parseApisObjectToText(protectedApis));
    }
}