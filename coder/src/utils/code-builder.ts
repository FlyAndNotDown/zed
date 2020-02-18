import { StringUtil } from "./string";

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

    public beginClass(type: 'class' | 'interface', className: string, ext: string, impl: string): CodeBuilder {
        this.code +=
            `public ${type} ${className} ` +
            ext == null || ext.length == 0 ? '' : `extends ${ext} ` +
            impl == null || impl.length == 0 ? '' : `implements ${impl} ` +
                '{\r\n';
        return this;
    }

    public beginFunc(
        override: boolean,
        access: 'public' | 'protected' | 'private',
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

    public beginContainerClass(taskName: string): ContainerCodeBuilder {
        return this.beginClass(
            'class',
            `Container${StringUtil.toFirstCharUpperCase(taskName)}`,
            null,
            `Container${StringUtil.toFirstCharUpperCase(taskName)}Callback`
        ) as ContainerCodeBuilder;
    }

    public beginContainerCallbackInterface(taskName: string): ContainerCodeBuilder {
        return this.beginClass(
            'interface',
            `Container${StringUtil.toFirstCharUpperCase(taskName)}Callback`,
            null,
            null
        ) as ContainerCodeBuilder;
    }

    public beginPluginClass(taskName: string): ContainerCodeBuilder {
        return this.beginClass(
            'class',
            `Plugin${StringUtil.toFirstCharUpperCase(taskName)}`,
            null,
            `Plugin${StringUtil.toFirstCharUpperCase(taskName)}Defined`
        ) as ContainerCodeBuilder;
    }

    public beginPluginDefinedInterface(taskName: string): ContainerCodeBuilder {
        return this.beginClass(
            'interface',
            `Plugin${StringUtil.toFirstCharUpperCase(taskName)}Defined`,
            null,
            null
        ) as ContainerCodeBuilder;
    }

    public addContainerFunc(
        taskName: string,
        access: 'public' | 'protected' | 'private',
        ret: string,
        funcName: string,
        args: string,
        override: boolean
    ): ContainerCodeBuilder {
        const hasRet: boolean = ret != null && ret.length != 0;
        if (override) {
            this.beginFunc(true, access, false, ret, funcName, args)
                .funcLine(`    if (pluginDefined == null) {`)
                .funcLine(`        ${hasRet ? '' : 'return '} super.${funcName};`)
                .funcLine(`    }`)
                .funcLine(`    ${hasRet ? '' : 'return '} $pluginDefined.${funcName}`)
                .endFunc();
        }
        return this.beginFunc(true, access, false, ret, `origin${StringUtil.toFirstCharUpperCase(funcName)}`, args)
            .funcLine(`    super.${funcName}`)
            .endFunc() as ContainerCodeBuilder;
    }

    public addContainerCallbackFunc(
        taskName: string,
        access: 'public' | 'protected' | 'private',
        ret: string,
        funcName: string,
        args: string
    ): ContainerCodeBuilder {
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