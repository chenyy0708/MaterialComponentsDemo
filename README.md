# MaterialComponents新控件Demo

> Google i/o 大会是每年程序员都很期待的会议，作为一个Android撸码员每次都期待Google发布一些开发神器、新控件。
今年Google带来了新的[Material Design](https://juejin.im/entry/5af4ff4d6fb9a07ac0224a16)的设计和定义风格，这里我们用网上流传的Material Design 2,后面用MD2来简写。

[Material Design 2 更新戳这里](https://juejin.im/entry/5af4ff4d6fb9a07ac0224a16)
  
## 1.导入material-components-android

不得不说，**material-components-android**的GitHub导入写的真的过分，啥都没有，导入一瞬间，报错一整天！最后我还是老老实实用[Android Studio 3.2 Canary](https://developer.android.google.cn/studio/preview/)版本来写了。 强烈推荐使用3.2，更新了很多新功能。
   
   
  **话不多说，直接就是干**
  
>  第一步打开项目的build.gradle文件添加jcenter和google
 
  ```
  allprojects {
  repositories {
    jcenter()
    maven {
      url "https://maven.google.com"
      }
    }
  }
  ```
>  第二步将库添加到app依赖
  
  ```
  dependencies {
  // ...
  compile 'com.google.android.material:material:1.0.0-alpha1'
    // ...
  }
  ```
  
写到这，我继续往下翻github的doc文档，恩~ 下面都是介绍怎么使用material-components了，真的开心，马上就可以使用google最新的控件了，想想就贼G2激动！
一运行，mmp事情果然没有那么简单，眉头还是皱晚了，没有事先察觉。

> Android resource linking failed
Output:  C:\Android Project\MyApplication\app\build\intermediates\incremental\mergeDebugResources\merged.dir\values-v28\values-v28.xml:7: error: resource android:attr/dialogCornerRadius not found



