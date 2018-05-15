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




google出来很多都是使用最新的`implementation 'com.android.support:appcompat-v7:28.0.0-alpha1`支持库，结果然并软，后来在[issues](https://github.com/material-components/material-components-android/issues/93)中发现了一位大佬的答案。更新`compileSdkVersion` Android P预览版即可，因为在使用28.0.0-alpha1的所有支持库时，缺少属性时会出现这个问题。

![更新compileSdkVersion](https://github.com/chenyy0708/MaterialComponentsDemo/blob/master/images/%E6%88%AA%E5%9B%BE1.jpg)




接下来我又可以开开心心的run了，emmmmmmmmmmmmm.....又gg

```
Program type already present: android.support.v4.os.ResultReceiver$MyResultReceiver
	at com.android.builder.dexing.D8DexArchiveMerger.getExceptionToRethrow(D8DexArchiveMerger.java:126)
	at com.android.builder.dexing.D8DexArchiveMerger.mergeDexArchives(D8DexArchiveMerger.java:111)
	at com.android.build.gradle.internal.transforms.DexMergerTransformCallable.call(DexMergerTransformCallable.java:101)
	at com.android.build.gradle.internal.transforms.ExternalLibsMergerTransform.transform(ExternalLibsMergerTransform.kt:123)
	at com.android.build.gradle.internal.pipeline.TransformTask$2.call(TransformTask.java:221)
	at com.android.build.gradle.internal.pipeline.TransformTask$2.call(TransformTask.java:217)
	at com.android.builder.profile.ThreadRecorder.record(ThreadRecorder.java:102)
```
这个错经过无数遍的google、百度都没找到是什么问题导致的，最后还是万能的[issues](https://github.com/material-components/material-components-android/issues/93)，提到使用最新Android studio 3.2预览版，`Refactor--Refactor to AndroiX>`转换成Android X项目，目前我也不懂这个AndroidX是个啥TnT，知道的大佬可以告诉俺=。=，之后就可以360°无死角的运行项目了，开始体验MD2喽~

**完整build.gradle文件**

```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 'android-P'
    defaultConfig {
        applicationId "com.example.horen.myapplication"
        minSdkVersion 21
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.0.0-alpha1'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.1.0-alpha1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0-alpha1'

    implementation 'com.google.android.material:material:1.0.0-alpha1'
}

```

