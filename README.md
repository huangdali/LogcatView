# LogcatView [![](https://www.jitpack.io/v/huangdali/LogcatView.svg)](https://www.jitpack.io/#huangdali/LogcatView)

日志记录抓取

> 没有数据线的时候，就用这个输出日志吧

- 使用简单，一行代码搞定
- 可抓取大部分Android Studio中Logcat打印的内容
- 可以搜索内容
- 可按tag过滤
- 可根据日志等级筛选（提供隐藏方法）
    - **A**  所有内容
    - **O**  System.out 输出的内容
    - **W**  警告级别的内容
    - **E**  错误级别的内容

## 集成

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```java
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

### Step 2. Add the dependency

```java
dependencies {
        compile 'com.github.huangdali:LogcatView:v1.0.2'
}
```

## 效果图
![](https://github.com/huangdali/LogcatView/blob/master/all.png)


![](https://github.com/huangdali/LogcatView/blob/master/search.png)

## 版本记录

v1.0.2 ([2017.09.30]())
- 【新增】项目初始化