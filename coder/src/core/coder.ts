import { CodingTask } from "../type/task";
import { API } from "../type/api";
import {Spider} from "./spider";
import {Porter} from "./porter";

export class Coder {
    private static async codingInternal(codingTask: CodingTask): Promise<void> {
        // TODO
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