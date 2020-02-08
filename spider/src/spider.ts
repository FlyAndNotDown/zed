import { config } from "./config";
import * as Cheerio from 'cheerio';
import {Log} from "./log";
import {default as Axios} from "axios";

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
        return null;
    }

    private static save(content: string): void {
        return null;
    }

    public static async fetchActivityApis(): Promise<void> {
        const source = await Spider.getSourceFromUrl(config.url.activity);
        const splitTemp = source.split('<!-- ========= METHOD DETAIL ======== -->');
        const publicMethodSource = splitTemp[1];
        const protectedMethodSource = splitTemp[2].split('<!-- ========= END OF CLASS DATA ========= -->')[0];
    }
}