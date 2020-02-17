export class CodeBuilder {
    protected code: string;

    protected constructor(code: string) {
        this.code = code;
    }

    public static begin(): CodeBuilder {
        return new CodeBuilder('');
    }

    public package(packageName: string): CodeBuilder {
        this.code += `package ${packageName}\r\n`;
        return this;
    }

    public beginClass(type: 'class | interface', className: string, ext: string, impl: string): CodeBuilder {
        this.code +=
            `public ${type} ${className} ` +
            ext == null || ext.length == 0 ? '' : `extends ${ext} ` +
            impl == null || impl.length == 0 ? '' : `implements ${impl} ` +
                '{\r\n';
        return this;
    }

    public beginFunc(
        override: boolean,
        access: 'public | protected | private',
        isStatic: boolean,
        ret: string,
        name: string,
        args: string
    ): CodeBuilder {
        this.code +=
            override ? '@Override\n' : '' +
            `${access} ` +
            `${isStatic ? 'static ' : ''}` +
            `${ret} ${name}(${args == null || args.length == 0 ? '' : args}) ` +
            `{\r\n`;
        return this;
    }

    public funcLine(line: string): CodeBuilder {
        this.code += `${line}\r\n`;
        return this;
    }

    public endFunc(): CodeBuilder {
        this.code += '}\r\n';
        return this;
    }

    public endClass(): CodeBuilder {
        this.code += '}\r\n';
        return this;
    }

    public end(): String {
        return this.code;
    }
}

export class ContainerCodeBuilder extends CodeBuilder {
    private constructor(code: string) {
        super(code);
    }

    public static begin(): ContainerCodeBuilder {
        return new ContainerCodeBuilder('');
    }

    public addContainerFunc(
        taskName: string,
        access: 'public | protected | private',
        isState: boolean,
        ret: string,
        name: string,
        args: string,
        override: boolean
    ): ContainerCodeBuilder {
        const hasRet: boolean = ret != null && ret.length != 0;
        if (override) {
            this.beginFunc(true, access, isState, ret, name, args)
                .funcLine(`if (${taskName}Defined == null) {`)
                .funcLine(`    ${hasRet ? '' : 'return '} super.${name};`)
                .funcLine(`}`)
                .funcLine(`${hasRet ? '' : 'return '} ${taskName}Defined.${name}`)
                .endFunc();
        }
        return this.beginFunc(true, access, isState, ret, `origin${taskName.charAt(0).toUpperCase() + name.substring(1)}`, args)
            .funcLine(`super.${name}`)
            .endFunc() as ContainerCodeBuilder;
    }

    public addContainerCallbackFunc(): ContainerCodeBuilder {
        // TODO
        return null;
    };

    public addPluginFunc(): ContainerCodeBuilder {
        // TODO
        return null;
    }

    public addPluginDefinedFunc(): ContainerCodeBuilder {
        // TODO
        return null;
    }
}