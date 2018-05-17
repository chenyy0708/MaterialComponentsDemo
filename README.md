# MaterialComponents新控件Demo

> Google i/o 大会是每年程序员都很期待的会议，作为一个Android撸码员每次都期待Google发布一些开发神器、新控件。
今年Google带来了新的[Material Design](https://juejin.im/entry/5af4ff4d6fb9a07ac0224a16)的设计和定义风格，这里我们用网上流传的Material Design 2,后面用MD2来简写。

[Material Design 2 更新戳这里](https://juejin.im/entry/5af4ff4d6fb9a07ac0224a16)
  
## 1. 导入material-components-android

不得不说，**material-components-android**的GitHub导入写的真的过分，啥都没有，不过也可能是我功力尚浅没找到，知道的大佬勿喷，*导入一瞬间，报错一整天*！最后我还是老老实实用[Android Studio 3.2 Canary](https://developer.android.google.cn/studio/preview/)版本来写了。 强烈推荐使用3.2，更新了很多新功能。
   
   
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



```
Android resource linking failed
Output:  C:\Android Project\MyApplication\app\build\intermediates\incremental\mergeDebugResources\merged.dir\values-v28\values-v28.xml:7: error: resource android:attr/dialogCornerRadius not found
```




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


## 2. MaterialComponents控件

*  [Bottom App Bars](https://github.com/chenyy0708/MaterialComponentsDemo#21-bottomappbar)
*  [Bottom Navigation](https://github.com/chenyy0708/MaterialComponentsDemo/blob/master/README.md#21-bottom-navigation)
*  Bottom Sheets
*  Chips
*  Collapsing Toolbars
*  Floating Action Buttons
*  Meiter Botton 
*  Meiter Card
*  Meiter Bottom Sheets
* Navigation Views
* Snackbars
* Tab Layout
* Text Fields
* Top App Bars



### 2.1 BottomAppBar

>这次google大会上也展示了这个控件，配合FloatingActionButton能实现很炫酷的组合形状。

在使用BottomAppBar之前如果app的style Theme没有使用以下属性的话，那么可以将BottomAppBar Material样式直接应用到XML中的窗口小部件。

* `Theme.MaterialComponents`
* `Theme.MaterialComponents.NoActionBar`
* `Theme.MaterialComponents.Light`
* `Theme.MaterialComponents.Light.NoActionBar`
* `Theme.MaterialComponents.Light.DarkActionBar`

### Material Styles
`style="@style/Widget.MaterialComponents.BottomAppBar"`


控件的基本属性


| 属性名        | 布局属性           |  说明 |
| :----------------: |:-------------:| :-----:|
| Background Tint      | app:backgroundTint | 设置背景颜色，调用background是不生效的  |
| FAB Alignment Mode      | app:fabAlignmentMode      |   起始对齐模式，center、end |
| FAB Cradle Margin      |    app:fabCradleMargin | 改变这个值会增加或减少FAB和BottomAppBar之间的视距。  |
| FAB Attached     |    app:fabAttached | 控制FAB和BottomAppBar的分离  |
| FAB Cradle Corner Radius     |   app:fabCradleRoundedCornerRadius | 指定切口周围角的圆度。  |
| FAB Vertical Offset     |   app:fabCradleVerticalOffset | 指定FAB和BottomAppBar之间的垂直偏移量。  |



* fabCradleVerticalOffset是指定FAB和BottomAppBar之间的垂直偏移量。如果fabCradleVerticalOffset为0，则FAB的中心将与BottomAppBar的顶部对齐。

* 通过调用setFabAlignmentMode（int），可以将FAB对齐到中心（FAB_ALIGNMENT_MODE_CENTER）或对齐右边（FAB_ALIGNMENT_MODE_END）。默认是有动画的。这可以与片段过渡相对协调。

### 2.1 Bottom Navigation

> BottomNavigationView creates bottom navigation bars, making it easy to explore and switch between top-level content views with a single tap.
This pattern can be used when you have between 3 and 5 top-level destinations to navigate to.

> BottomNavigationView创建底部导航栏，使用户只需轻点一下即可轻松浏览和切换顶级内容视图。 当您有3到5个顶层目的地导航到时，可以使用此模式。

#### 开始使用

1. 创建一个Menu布局，最多5个导航目标（BottomNavigationView不支持超过5个）。
2. 在xml中放置BottomNavigationView。
3. 将BottomNavigationView上的app：menu属性设置为您的菜单资源布局。
4. 使用setOnNavigationItemSelectedListener（...）监听选择点击事件。

```
 <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".BottomNavigationActivity">

    <TextView
        android:id="@+id/message"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/activity_horizontal_margin"
        android:layout_marginLeft="@dimen/activity_horizontal_margin"
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:text="@string/title_home"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/navigation"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="0dp"
        android:layout_marginEnd="0dp"
        style="@style/Widget.MaterialComponents.BottomNavigationView"
        app:itemIconTint="@drawable/bottom_navigation_colors"
        app:itemTextColor="@drawable/bottom_navigation_colors"
        android:background="?android:attr/windowBackground"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:menu="@menu/navigation" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

app：itemIconTint(图标选择颜色) 和app：itemTextColor(文字选择颜色) 采用ColorStateList而不是简单的设置颜色。这样我们可以定义一个selector 来设置选中和未选中的颜色。

```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:state_checked="true"
        android:color="@color/colorPrimary" />
    <item
        android:state_checked="false"
        android:color="@android:color/darker_gray" />
</selector>
```

app:itemIconSize可以设置导航图标的大小。


### 2.3 Bottom Sheets







