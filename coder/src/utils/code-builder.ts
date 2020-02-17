export class ContainerCodeBuilder {
    private code: string;

    private constructor(code: string) {
        this.code = code;
    }

    public static begin(): ContainerCodeBuilder {
        return new ContainerCodeBuilder('');
    }

    public package(packageName: string): ContainerCodeBuilder {
        this.code += `package ${packageName}\r\n`;
        return this;
    }

    public beginClass(className: string, ext: string, impl: string): ContainerCodeBuilder {
        this.code +=
            `public class ${className} ` +
            ext == null || ext.length == 0 ? '' : `extends ${ext} ` +
            impl == null || impl.length == 0 ? '' : `implements ${impl} ` +
            '{\r\n';
        return this;
    }

    public endClass(): ContainerCodeBuilder {
        this.code += '}\r\n';
        return this;
    }

    public end(): String {
        return this.code;
    }
}