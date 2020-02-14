import * as Path from 'path';
import { Config } from "./type/config";

export const config: Config = {
    log: true,
    save: Path.resolve(__dirname, '../output'),
    tasks: [{
        name: 'android.app.Activity',
        url: 'https://developer.android.google.cn/reference/android/app/Activity?hl=en',
    }, {
        name: 'android.app.Service',
        url: 'https://developer.android.google.cn/reference/kotlin/android/app/Service?hl=en'
    }, {
        name: 'android.app.Application',
        url: 'https://developer.android.google.cn/reference/android/app/Application?hl=en'
    }, {
        name: 'android.app.Fragment',
        url: 'https://developer.android.google.cn/reference/android/app/Fragment?hl=en'
    }]
};