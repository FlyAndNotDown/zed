export class ApiRule {
    public static match(apiName: string): boolean {
        return false;
    }

    public static work(apiName: string): string {
        return '';
    }
}

// Container Rules -------------------------------------------------------

class ContainerGetApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('get');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class ContainerSetApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('set');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class ContainerDispatchApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('dispatch');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class ContainerOnApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('on');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class ContainerUniqueApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        // TODO
        return false;
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class ContainerDefaultApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return true;
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

// SDK Rules ---------------------------------------------------------------

class SdkGetApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('get');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class SdkSetApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('set');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class SdkOnApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return apiName.startsWith('on');
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class SdkUniqueApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        // TODO
        return false;
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

class SdkDefaultApiRule extends ApiRule {
    public static match(apiName: string): boolean {
        return true;
    }

    public static work(apiName: string): string {
        // TODO
        return '';
    }
}

// Declared ---------------------------------------------------------------

export const containerApiRules: ApiRule[] = [
    ContainerGetApiRule,
    ContainerSetApiRule,
    ContainerDispatchApiRule,
    ContainerOnApiRule,
    ContainerUniqueApiRule,
    ContainerDefaultApiRule
];

export const sdkGetApiRule: ApiRule[] = [
    SdkGetApiRule,
    SdkSetApiRule,
    SdkOnApiRule,
    SdkUniqueApiRule,
    SdkDefaultApiRule
];