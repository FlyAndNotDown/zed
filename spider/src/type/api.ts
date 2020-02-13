export interface API {
    name: string,
    levelAdded: string,
    levelDeprecated: string,
    prototype: string,
    throws: string,
}

export interface ApiExcelSheet {
    name: string,
    data: string[][]
}