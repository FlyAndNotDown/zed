import { config } from "./config";
import { LogUtil } from "./utils/log";
import * as Path from 'path';
import { NetworkUtil } from "./utils/network";
import { PageResolutionUtil } from "./utils/page-resolution";
import { FileUtil } from "./utils/file";
import { API, ApiExcelSheet } from "./type/api";
import { Constant } from "./utils/Constant";

export class Spider {
    private static async fetchApis(taskName: string, url: string, savePath: string): Promise<void> {
        const source: string = await NetworkUtil.getSourceFromUrl(url);
        const splitTemp: string[] = source.split(Constant.PUBLIC_METHOD_TAG);
        const publicMethodSource: string = splitTemp[1];
        const protectedMethodSource: string = splitTemp[2].split(Constant.PROTECTED_METHOD_TAG)[0];

        LogUtil.log('info', `starting fetch ${taskName} public apis`);
        const publicApis: API[] = PageResolutionUtil.getApis(publicMethodSource);
        const publicApiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(publicApis, 'public');

        LogUtil.log('info', `starting fetch ${taskName} protected apis`);
        const protectedApis: API[] = PageResolutionUtil.getApis(protectedMethodSource);
        const protectedApiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(protectedApis, 'protected');

        LogUtil.log('info', `saved apis to ${savePath}`);
        FileUtil.save(savePath, [publicApiExcelSheet, protectedApiExcelSheet]);
    }

    public static async fetchActivityApis(): Promise<void> {
        await Spider.fetchApis(
            'activity',
            config.url.activity,
            Path.resolve(config.save, 'activity', 'apis.xlsx')
        );
    }
}