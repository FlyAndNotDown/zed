export interface SpiderTask {
    name: string,
    url: string
}

export interface CopyTask {
    fileFrom: string,
    fileTo: string
}

export interface CodingTask {
    packageName: string,
    type: 'container' | 'sdk'
    preTask: SpiderTask,
    afterTask: CopyTask
}