import { CodingTask } from "../type/task";
import { API } from "../type/api";
import { Spider } from "./spider";
import { Porter } from "./porter";
import { FileUtil } from "../utils/file";
import { config } from "../config";
import * as Path from 'path';

class ContainerCoder {
    private static async writeContainerClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async writeContainerCallbackClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async writePluginClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async writePluginDefinedClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    public static async writeContainerCode(codingTask: CodingTask): Promise<void> {
        const apis: API[] = FileUtil.parseExcelSheetToApis(
            FileUtil.loadApiExcelSheetFromFile(Path.resolve(config.apiSavePath, `${codingTask.preTask.name}.xlsx`))[0]);
        await ContainerCoder.writeContainerClass(codingTask, apis);
        await ContainerCoder.writeContainerCallbackClass(codingTask, apis);
        await ContainerCoder.writePluginClass(codingTask, apis);
        await ContainerCoder.writePluginDefinedClass(codingTask, apis);
    }
}

class SdkCoder {
    private static async writePluginClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    public static async writeSdkCode(codingTask: CodingTask): Promise<void> {
        const apis: API[] = FileUtil.parseExcelSheetToApis(
            FileUtil.loadApiExcelSheetFromFile(Path.resolve(config.apiSavePath, `${codingTask.preTask.name}.xlsx`))[0]);
        await SdkCoder.writePluginClass(codingTask, apis);
    }
}

export class Coder {
    private static async writeCode(codingTask: CodingTask): Promise<void> {
        if (codingTask.type === 'container') {
            await ContainerCoder.writeContainerCode(codingTask);
        } else if (codingTask.type === 'sdk') {
            await SdkCoder.writeSdkCode(codingTask);
        }
    }

    private static async executeCodingTask(codingTask: CodingTask): Promise<void> {
        await Spider.executeSpiderTask(codingTask.preTask);
        await Coder.writeCode(codingTask);
        await Porter.executeCopyTask(codingTask.afterTask);
    }

    public static async executeCodingTasks(codingTasks: CodingTask[]): Promise<void> {
        for (let i = 0; i < codingTasks.length; i++) {
            await Coder.executeCodingTask(codingTasks[i]);
        }
    }
}