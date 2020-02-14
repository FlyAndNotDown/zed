import * as Path from 'path';
import { Config } from "./type/config";

export const config: Config = {
    log: true,
    save: Path.resolve(__dirname, '../output'),
    tasks: [{
        packageName: 'pers.kindem.zed.test.container.activity',
        type: 'container',
        preTask: {
            name: 'android.app.Activity',
            url: 'https://developer.android.google.cn/reference/android/app/Activity?hl=en'
        },
        afterTask: null
    }, {
        packageName: 'pers.kindem.zed.test.container.service',
        type: 'container',
        preTask: {
            name: 'android.app.Service',
            url: 'https://developer.android.google.cn/reference/kotlin/android/app/Service?hl=en'
        },
        afterTask: null
    }, {
        packageName: 'pers.kindem.zed.test.container.fragment',
        type: 'container',
        preTask: {
            name: 'android.app.Fragment',
            url: 'https://developer.android.google.cn/reference/android/app/Fragment?hl=en'
        },
        afterTask: null
    }, {
        packageName: 'pers.kindem.zed.test.container.Application',
        type: 'sdk',
        preTask: {
            name: 'android.app.Application',
            url: 'https://developer.android.google.cn/reference/android/app/Application?hl=en'
        },
        afterTask: null
    }]
};
