import { LogUtil } from "../utils/log";
import { NetworkUtil } from "../utils/network";
import { PageResolutionUtil } from "../utils/page-resolution";
import { FileUtil } from "../utils/file";
import { API, ApiExcelSheet } from "../type/api";
import { SpiderTask } from "../type/task";
import { config } from "../config";
import * as Path from 'path';
import * as Cheerio from "cheerio";

export class Spider {
    public static async executeSpiderTask(spiderTask: SpiderTask): Promise<void> {
        const source: string = await NetworkUtil.getSourceFromUrl(spiderTask.url);
        const $: CheerioStatic = Cheerio.load(source);
        LogUtil.log('info', `starting fetch ${spiderTask.name} apis`);
        const apis: API[] = PageResolutionUtil.getApis($);
        const apiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(apis, 'activity');
        const savePath: string = Path.resolve(config.apiSavePath, `${spiderTask.name}.xlsx`);
        LogUtil.log('info', `saved apis to ${savePath}`);
        FileUtil.saveApiExcelSheetToFile(savePath, [apiExcelSheet]);
    }
}