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

    public static getApis($: CheerioStatic): API[] {
        const apis: API[] = [];
        let apiCount: number = 0;
        $('div[data-version-added]').each(function () {
            const name: string = $('h3.api-name', this).text();
            const firstChar: string = name.charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                return;
            }
            apis.push({
                name: name,
                levelAdded: $(this).attr('data-version-added'),
                levelDeprecated: $(this).attr('data-version-deprecated') || '0',
                prototype: PageResolutionUtil.getApiPrototype($, this),
                throws: PageResolutionUtil.getThrows($, this)
            });
            apiCount++;
        });
        LogUtil.log('info', `found total ${apiCount} apis`);
        return apis;
    }
}