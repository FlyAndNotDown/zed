import { LogUtil } from "./log";
import { API } from "../type/api";

export class PageResolutionUtil {
    private static getName($: CheerioStatic, context: CheerioElement): string {
        return $('h3.api-name', context).text();
    }

    private static getLevelAdded($: CheerioStatic, context: CheerioElement): string {
        return $(context).attr('data-version-added');
    }

    private static getLevelDeprecated($: CheerioStatic, context: CheerioElement) {
        return $(context).attr('data-version-deprecated') || '0'
    }

    private static getApiPrototype($: CheerioStatic, context: CheerioElement): string {
        let apiPrototype: string = '';
        $('pre.api-signature', context).each(function () {
            apiPrototype += $(this).text();
        });
        return apiPrototype
            .replace(/\n/g, ' ')
            .replace(/ +/g, ' ')
            .replace(/ \(/g, '(');
    }

    private static getThrows($: CheerioStatic, context: CheerioElement): string {
        let throws: string = "";
        $('table', context).each(function () {
            const tableTitle: string = $('th', this).text();
            if (tableTitle === 'Throws') {
                throws = $('td', this).first().text();
            }
        });
        return throws;
    }

    private static checkNeedSave(name: string): boolean {
        const firstChar: string = name.charAt(0);
        return !(firstChar >= 'A' && firstChar <= 'Z' || name === '<init>');
    }

    public static getApis($: CheerioStatic): API[] {
        const apis: API[] = [];
        let apiCount: number = 0;
        $('div[data-version-added]').each(function () {
            const name: string = PageResolutionUtil.getName($, this);
            if (!PageResolutionUtil.checkNeedSave(name)) {
                return;
            }
            apis.push({
                name: name,
                levelAdded: PageResolutionUtil.getLevelAdded($, this),
                levelDeprecated: PageResolutionUtil.getLevelDeprecated($, this),
                prototype: PageResolutionUtil.getApiPrototype($, this),
                throws: PageResolutionUtil.getThrows($, this)
            });
            apiCount++;
        });
        LogUtil.log('info', `found total ${apiCount} apis`);
        return apis;
    }
}