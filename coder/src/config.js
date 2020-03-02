import * as Path from 'path';

export const defaultConfig = {
    path: {
        middleware: Path.resolve(__dirname, '..', 'middleware')
    }
};

export const config = {
    debug: true,
    log: true,
    saveMiddleware: true,
    path: {
        middleware: Path.resolve(__dirname, '..', 'middleware')
    }
};