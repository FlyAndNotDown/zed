import { config } from "../config";

export class LogUtil {
    public static log(tag: String, info: String): void {
        if (!config.log) {
            return;
        }
        console.log(`[${tag}] ${info}`);
    }
}