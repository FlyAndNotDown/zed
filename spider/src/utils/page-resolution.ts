import * as Cheerio from "cheerio";
import { LogUtil } from "./log";
import { API } from "../type/api";

export class PageResolutionUtil {
    public static getApiPrototype($: CheerioStatic, context: CheerioElement): string {
        let apiPrototype: string = '';
        $('pre.api-signature', context).each(function () {
            apiPrototype += $(this).text();
        });
        return apiPrototype
            .replace(/\n/g, ' ')
            .replace(/ +/g, ' ')
            .replace(/ \(/g, '(');
    }

    public static getThrows($: CheerioStatic, context: CheerioElement): string {
        let throws: string = "";
        $('table', context).each(function () {
            const tableTitle: string = $('th', this).text();
            if (tableTitle === 'Throws') {
                throws = $('td', this).first().text();
            }
        });
        return throws;
    }

    public static getApis(source: string): API[] {
        const apis: API[] = [];
        const $: CheerioStatic = Cheerio.load(source);
        let apiCount: number = 0;
        $('div[data-version-added]').each(function (index, context) {
            apis.push({
                name: $('h3.api-name', context).text(),
                levelAdded: $(context).attr('data-version-added'),
                levelDeprecated: $(context).attr('data-version-deprecated') || '0',
                prototype: PageResolutionUtil.getApiPrototype($, context),
                throws: PageResolutionUtil.getThrows($, context)
            });
            apiCount++;
        });
        LogUtil.log('info', `found total ${apiCount} apis`);
        return apis;
    }
}