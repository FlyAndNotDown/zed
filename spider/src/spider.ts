import { config } from "./config";
import * as Cheerio from 'cheerio';
import { Log } from "./log";
import { default as Axios } from "axios";
import * as FileSystem from 'fs';

export interface API {

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
        return null;
    }

    private static parseApisObjectToText(apis: API[]): string {
        const result: string = '';
        apis.forEach(api => {});
        return result;
    }

    private static save(file: string, content: string): void {
        FileSystem.writeFileSync(file, content);
    }

    public static async fetchActivityApis(): Promise<void> {
        const source: string = await Spider.getSourceFromUrl(config.url.activity);
        const splitTemp: string[] = source.split('<!-- ========= METHOD DETAIL ======== -->');
        const publicMethodSource: string = splitTemp[1];
        const protectedMethodSource: string = splitTemp[2].split('<!-- ========= END OF CLASS DATA ========= -->')[0];
        const publicApis: API[] = Spider.getApis(publicMethodSource);
        const protectedApis: API[] = Spider.getApis(protectedMethodSource);
        Spider.save('../output/activity/public.txt', Spider.parseApisObjectToText(publicApis));
        Spider.save('../output/activity/protected', Spider.parseApisObjectToText(protectedApis));
    }
}