package pers.kindem.zed.runtime.bean;

public class PluginLoadInfo {
    private String name;
    private String component;

    public PluginLoadInfo() {
        name = "";
        component = "";
    }

    public PluginLoadInfo(String name, String component) {
        this.name = name;
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
