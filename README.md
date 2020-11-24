# Zed

一个优雅的 `Android` 插件化框架

---

## 介绍

所谓插件化，作用是让应用能够免安装运行。`Android` 的插件化简单来说，原理是使用 `Java` 的反射机制使得 `Apk` 中的代码能够直接被执行。

插件化带来的优势也很明显，它使得一个完整的 `Apk` 可以作为一份资源被存储与下载，需要执行的时候再拿出来动态加载。我们常见的 `QQ`、`Didi` 等众多应用中，都使用了插件化技术，某些界面、逻辑可以在应用未重新安装的情况下，通过网络直接热更新。

众所周知，`Android` 中有四大组件：

* `Activity`
* `Service`
* `BroadcastReceiver`
* `ContentProvider`

另外还有：

* `Application`
* `Fragment`

光让代码能够动态执行也不行，让 `Apk` 中的组件能够被系统认可也是一门学问，而插件化框架所作的事情，就是帮助 `Apk` 中的组件被系统认可，我们称这一技术为**容器**。

市面上的插件化框架很多，有 `Tecent` 的 `Shadow`，`Didi` 的 `VirtualApk`，你看见的 `Zed`，也终将成为它们中优秀的一员。

## 想要学习原理？

可以关注[我的博客](https://www.kindem.xyz/)，我会在项目完成后逐步更新 `ClassLoader`、`插件化容器` 等相关课程，详细讲解其中原理。

## 支持功能

计划支持的功能如下，将不定期更新：

* 容器
    * `Activity`
    * `Service`
    * `BroadcastReceiver`
    * `ContentProvider`
    * `Application`
    * `Fragment` / `XML Fragment`
* 字节码替换
    * `Gradle Transform API` 插件
    * 无缝切换插件 / 正常模式
* 插件管理服务
    * 宿主子进程分配
    * 多插件管理
    * 插件安装 / 升级 / 卸载
    * 插件负载均衡
    * 插件通信
    * 插件内置客户端与服务器
    * 容器资源分配
* 其他
    * `AndroidX` / `SupportSDK` 支持
    * `LayoutInflator` 注入
    * `Application`、`Activity` 主题支持
    * 部分系统主题支持，如 `EMUI`、`MIUI`
    * 自定义容器桩定制

## 贡献代码

`Fork` 本仓库，修改代码，发起 `Pull Request` 即可。`UT` 和流水线将逐步搭建。

## 为什么要叫 Zed？

当然因为**她和影流都是劫**，( 逃
