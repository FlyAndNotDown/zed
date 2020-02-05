export class Log {
    public static log(tag: String, info: String): void {
        console.log(`[${tag}] ${info}`);
    }
}