# InstagramLikeColorTransition
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-InstagramLikeColorTransition-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5035)

在Android中创建类似Instagram的渐变背景

<img src="https://github.com/Taishi-Y/InstagramLikeColorTransitionAndroid/blob/master/images/screenshot.gif?raw=true" 
alt="" width="250" border="10" />

#### 1. 在drawable文件夹创建一些渐变颜色的资源
color1.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:startColor="#614385"
        android:endColor="#516395"
        android:angle="0"/>
</shape>

```

color2.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:startColor="#5f2c82"
        android:endColor="#49a09d"
        android:angle="45"/>
</shape>
```

color3.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:startColor="#4776E6"
        android:endColor="#8E54E9"
        android:angle="90"/>
</shape>
```

color4.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:startColor="#7141e2"
        android:endColor="#d46cb3"
        android:angle="135"/>
</shape>
```

#### 2. 创建一个用到上面创建的渐变色的动画序列，命名为animation_list.xml,放进去drawable文件夹
```xml
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/color1"
        android:duration="10000" />
    <item
        android:drawable="@drawable/color2"
        android:duration="10000" />
    <item
        android:drawable="@drawable/color3"
        android:duration="10000" />
    <item
        android:drawable="@drawable/color4"
        android:duration="10000" />
</animation-list>
```

#### 3. 将上面已经创建好的动画序列应用到你layout的背景顶层的view中
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@drawable/animation_list"
    android:id="@+id/container">

    <!-- Child Views -->

</LinearLayout>
```

#### 4.在你的activity中用AnimationDrawable去实现过渡效果
```java
LinearLayout container = (LinearLayout) findViewById(R.id.container);

AnimationDrawable anim = (AnimationDrawable) container.getBackground();
anim.setEnterFadeDuration(6000);
anim.setExitFadeDuration(2000);

// 开始播放动画：在onResume方法中开始播放渐变动画
@Override
protected void onResume() {
    super.onResume();
    if (anim != null && !anim.isRunning())
        anim.start();
}
      
// 停止播放动画：在onPause方法中停止播放渐变动画
@Override
protected void onPause() {
    super.onPause();
    if (anim != null && anim.isRunning())
        anim.stop();
}
```

### 将状态栏设置透明（去除状态栏）

values/styles.xml
```xml
<resources>  
    <style name="Theme.AppTheme.TranslucentStatusBar" parent="Theme.AppCompat.Light.NoActionBar" />  
</resources>  
```


values-v19/styles.xml
```xml
<resources>  
    <style name="Theme.AppTheme.TranslucentStatusBar" parent="Theme.AppCompat.Light.NoActionBar">  
        <item name="android:windowTranslucentStatus">true</item>  
    </style>  
</resources> 
```


values-v21/styles.xml
```xml
<resources>  
    <style name="Theme.AppTheme.TranslucentStatusBar" parent="Theme.AppCompat.Light.NoActionBar">  
        <item name="android:statusBarColor">@android:color/transparent</item>  
    </style>  
</resources>  
```


values-v23/styles.xml
```xml
<resources>  
    <style name="Theme.AppTheme.TranslucentStatusBar" parent="Theme.AppCompat.Light.NoActionBar">  
        <item name="android:statusBarColor">@android:color/transparent</item>  
        <item name="android:windowLightStatusBar">true</item>  
    </style>  
</resources> 
```

```java

public class MainActivity extends AppCompatActivity {  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
  
        // 加入下面的代码
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  
            findViewById(android.R.id.content).setSystemUiVisibility(  
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);  
        }  
  
        setContentView(R.layout.activity_splash);  
    }  
}  
```

```xml 
<activity  
    android:name=".MainActivity"  
    android:theme="@style/Theme.AppTheme.TranslucentStatusBar" /> 
```


# License

    Copyright 2017 Taishi Yamasaki

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.