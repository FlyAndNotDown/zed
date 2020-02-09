import * as Path from 'path';

export interface UrlConfig {
    activity?: string,
    service?: string,
    fragment?: string
}

export interface Config {
    log?: boolean,
    url?: UrlConfig,
    save?: string
}

export const config: Config = {
    log: true,
    url: {
        activity: 'https://developer.android.google.cn/reference/android/app/Activity?hl=en'
    },
    save: Path.resolve(__dirname, '../output')
};