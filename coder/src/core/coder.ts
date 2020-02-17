import { CodingTask } from "../type/task";
import { API } from "../type/api";
import { Spider } from "./spider";
import { Porter } from "./porter";
import { FileUtil } from "../utils/file";
import { config } from "../config";
import * as Path from 'path';

class ContainerCoder {
    private static async codingContainerClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async codingContainerCallbackClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async codingContainerPluginClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    private static async codingContainerPluginDefinedClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    public static async codingContainer(codingTask: CodingTask): Promise<void> {
        const apis: API[] = FileUtil.parseExcelSheetToApis(
            FileUtil.loadApiExcelSheetFromFile(Path.resolve(config.apiSavePath, `${codingTask.preTask.name}.xlsx`))[0]);
        await ContainerCoder.codingContainerClass(codingTask, apis);
        await ContainerCoder.codingContainerCallbackClass(codingTask, apis);
        await ContainerCoder.codingContainerPluginClass(codingTask, apis);
        await ContainerCoder.codingContainerPluginDefinedClass(codingTask, apis);
    }
}

class SdkCoder {
    private static async codingSdkClass(codingTask: CodingTask, apis: API[]): Promise<void> {
        // TODO
    }

    public static async codingSdk(codingTask: CodingTask): Promise<void> {
        const apis: API[] = FileUtil.parseExcelSheetToApis(
            FileUtil.loadApiExcelSheetFromFile(Path.resolve(config.apiSavePath, `${codingTask.preTask.name}.xlsx`))[0]);
        await SdkCoder.codingSdkClass(codingTask, apis);
    }
}

export class Coder {
    private static async codingInternal(codingTask: CodingTask): Promise<void> {
        if (codingTask.type === 'container') {
            await ContainerCoder.codingContainer(codingTask);
        } else if (codingTask.type === 'sdk') {
            await SdkCoder.codingSdk(codingTask);
        }
    }

    private static async executeCodingTask(codingTask: CodingTask): Promise<void> {
        await Spider.executeSpiderTask(codingTask.preTask);
        await Coder.codingInternal(codingTask);
        await Porter.executeCopyTask(codingTask.afterTask);
    }

    public static async executeCodingTasks(codingTasks: CodingTask[]): Promise<void> {
        for (let i = 0; i < codingTasks.length; i++) {
            await Coder.executeCodingTask(codingTasks[i]);
        }
    }
}