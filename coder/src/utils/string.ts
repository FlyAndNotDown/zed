export class StringUtil {
    public static toFirstCharUpperCase(source: string): string {
        return source.charAt(0).toUpperCase() + source.substring(1);
    }
}