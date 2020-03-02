import { config } from '../config';

export class LogUtil {
    static debug(tag, content) {
        if (config.debug) {
            console.log(`[${tag}] ${content}`);
        }
    }

    static info(tag, content) {
        console.log(`[${tag}] ${content}`);
    }
}