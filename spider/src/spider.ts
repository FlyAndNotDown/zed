import { config } from "./config";
import { LogUtil } from "./utils/log";
import * as Path from 'path';
import { NetworkUtil } from "./utils/network";
import { PageResolutionUtil } from "./utils/page-resolution";
import { FileUtil } from "./utils/file";
import { API, ApiExcelSheet } from "./type/api";
import * as Cheerio from "cheerio";

export class Spider {
    private static async fetchApis(taskName: string, url: string, savePath: string): Promise<void> {
        const source: string = await NetworkUtil.getSourceFromUrl(url);
        const $: CheerioStatic = Cheerio.load(source);
        LogUtil.log('info', `starting fetch ${taskName} public apis`);
        const apis: API[] = PageResolutionUtil.getApis($);
        const apiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(apis, 'activity');
        LogUtil.log('info', `saved apis to ${savePath}`);
        FileUtil.save(savePath, [apiExcelSheet]);
    }

    public static async fetchActivityApis(): Promise<void> {
        await Spider.fetchApis(
            'activity',
            config.url.activity,
            Path.resolve(config.save, 'activity.xlsx')
        );
    }

    public static async fetchServiceApis(): Promise<void> {
        await Spider.fetchApis(
            'service',
            config.url.service,
            Path.resolve(config.save, 'service.xlsx')
        );
    }
}