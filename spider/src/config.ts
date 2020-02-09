import * as Path from 'path';

export interface UrlConfig {
    activity?: string,
    service?: string,
    fragment?: string
}

export interface Config {
    url?: UrlConfig,
    save?: string
}

export const config: Config = {
    url: {
        activity: 'https://developer.android.google.cn/reference/android/app/Activity?hl=en'
    },
    save: Path.resolve(__dirname, '../output')
};