import * as FileSystem from 'fs';
import * as Path from 'path';

export class FileUtil {
    static checkDirAndMake(dirPath) {
        if (!FileSystem.existsSync(dirPath)) {
            FileUtil.checkDirAndMake(Path.resolve(dirPath, '..'));
            FileSystem.mkdirSync(dirPath);
        }
    }
}