import { default as Axios } from 'axios';
import { config, defaultConfig } from '../config';
import { FileUtil } from '../utils/FileUtil';
import * as FileSystem from 'fs';
import * as Path from 'path';

export class Downloader {
    static async download(name, url) {
        const source = await Axios.get(url);
        if (config.saveMiddleware) {
            let savePath = defaultConfig.path.middleware;
            if (config.path && config.path.middleware) {
                savePath = config.path.middleware;
            }
            savePath = Path.resolve(savePath, 'source');
            FileUtil.checkDirAndMake(savePath);
            FileSystem.writeFileSync(Path.resolve(savePath, `${name}.html`), source.data);
        }
        return source;
    }
}