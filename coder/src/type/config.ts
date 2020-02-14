import { SpiderTask } from "./spider";

export interface Config {
    log: boolean,
    save: string,
    tasks: SpiderTask[]
}