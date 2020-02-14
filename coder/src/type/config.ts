import { CodingTask } from "./task";

export interface Config {
    log: boolean,
    save: string,
    tasks: CodingTask[]
}