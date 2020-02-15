import { CodingTask } from "./task";

export interface Config {
    log: boolean,
    apiSavePath: string,
    tasks: CodingTask[]
}