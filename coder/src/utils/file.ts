import * as Path from "path";
import * as FileSystem from "fs";
import * as ExcelDealer from "node-xlsx";
import { API, ApiExcelSheet } from "../type/api";

export class FileUtil {
    private static checkAndMkdir(path: string): void {
        const parent: string = Path.resolve(path, '..');
        if (!FileSystem.existsSync(parent)) {
            FileUtil.checkAndMkdir(parent);
        }
        if (!FileSystem.existsSync(path)) {
            FileSystem.mkdirSync(path);
        }
    }

    public static parseApisToExcelSheet(apis: API[], name: string): ApiExcelSheet {
        const title: string[] = [
            'Name', 'LevelAdded', 'LevelDeprecated', 'Prototype', 'Throws'
        ];
        let rows: string[][] = [title];

        apis.forEach(api => {
            rows.push([
                api.name,
                api.levelAdded,
                api.levelDeprecated,
                api.prototype,
                api.throws
            ]);
        });

        return {
            name: name,
            data: rows
        };
    }

    public static parseExcelSheetToApis(apiExcelSheet: ApiExcelSheet): API[] {
        // TODO
        return [];
    }

    public static saveApiExcelSheetToFile(file: string, apiExcelSheets: ApiExcelSheet[]): void {
        FileUtil.checkAndMkdir(Path.resolve(file, '..'));
        if (FileSystem.existsSync(file)) {
            FileSystem.unlinkSync(file);
        }
        FileSystem.writeFileSync(file, ExcelDealer.build(apiExcelSheets), 'binary');
    }

    public static loadApiExcelSheetFromFile(file: string): ApiExcelSheet[] {
        // TODO
        return [];
    }
}