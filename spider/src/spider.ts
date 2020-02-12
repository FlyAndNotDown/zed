import { config } from "./config";
import { LogUtil } from "./utils/log";
import * as Path from 'path';
import { NetworkUtil } from "./utils/network";
import { PageResolutionUtil } from "./utils/page-resolution";
import { FileUtil } from "./utils/file";
import { API, ApiExcelSheet } from "./type/api";

export class Spider {
    public static async fetchActivityApis(): Promise<void> {
        const source: string = await NetworkUtil.getSourceFromUrl(config.url.activity);
        const splitTemp: string[] = source.split('<!-- ========= METHOD DETAIL ======== -->');
        const publicMethodSource: string = splitTemp[1];
        const protectedMethodSource: string = splitTemp[2].split('<!-- ========= END OF CLASS DATA ========= -->')[0];

        LogUtil.log('info', 'starting fetch activity public apis');
        const publicApis: API[] = PageResolutionUtil.getApis(publicMethodSource);
        const publicApiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(publicApis, 'public');

        LogUtil.log('info', 'starting fetch activity protected apis');
        const protectedApis: API[] = PageResolutionUtil.getApis(protectedMethodSource);
        const protectedApiExcelSheet: ApiExcelSheet = FileUtil.parseApisToExcelSheet(protectedApis, 'protected');

        const savePath: string = Path.resolve(config.save, 'activity', 'apis.xlsx');
        LogUtil.log('info', `saved apis to ${savePath}`);
        FileUtil.save(savePath, [publicApiExcelSheet, protectedApiExcelSheet]);
    }
}