import { LogUtil } from "../utils/log";
import { NetworkUtil } from "../utils/network";
import { PageResolutionUtil } from "../utils/page-resolution";
import { FileUtil } from "../utils/file";
import { API, ApiExcelSheet } from "../type/api";
import { SpiderTask } from "../type/task";
import * as Cheerio from "cheerio";

export class Spider {
    public static async executeSpiderTask(spiderTask: SpiderTask): Promise<void> {
        const source: string = await NetworkUtil.getSourceFromUrl(spiderTask.url);
        const $: CheerioStatic = Cheerio.load(source);
        LogUtil.log('info', `starting fetch ${spiderTask.name} public apis`);
        const apis: API[] = PageResolutionUtil.getApis($);
        const apiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(apis, 'activity');
        const savePath: string = `${spiderTask.name}.xlsx`;
        LogUtil.log('info', `saved apis to ${savePath}`);
        FileUtil.save(savePath, [apiExcelSheet]);
    }
}