export interface UrlConfig {
    activity?: string,
    service?: string,
    fragment?: string
}

export interface Config {
    url?: UrlConfig
}

export const config: Config = {
    url: {
        activity: 'https://developer.android.google.cn/reference/android/app/Activity?hl=en'
    }
};