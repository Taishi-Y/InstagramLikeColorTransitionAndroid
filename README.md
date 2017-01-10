# InstagramLikeColorTransition
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-InstagramLikeColorTransition-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5035)

How to create instagram like Gradient color transition in android.

<img src="https://github.com/Taishi-Y/InstagramLikeColorTransitionAndroid/blob/master/images/screenshot.gif?raw=true" 
alt="" width="250" border="10" />

#### 1. Create some gradient color drawables inside drawable Folder.

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
    
#### 2. Create animation list using the above created gradient colors, animation_list.xml, inside drawable folder

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
    
#### 3. Apply the animation_list created above as a background to the top view of your activity layout.

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
    
#### 4. Inside your activity use AnimationDrawable to apply the transition.
```java
LinearLayout container = (LinearLayout) findViewById(R.id.container);

AnimationDrawable anim = (AnimationDrawable) container.getBackground();
anim.setEnterFadeDuration(6000);
anim.setExitFadeDuration(2000);

// Starting animation:- start the animation on onResume.
@Override
protected void onResume() {
    super.onResume();
    if (anim != null && !anim.isRunning())
        anim.start();
}
      
// Stopping animation:- stop the animation on onPause.
@Override
protected void onPause() {
    super.onPause();
    if (anim != null && anim.isRunning())
        anim.stop();
}
```
  

### Make statusbar transparent

values/styles.xml
```xml
<resources>  
    <style name="Theme.AppTheme.TranslucentStatusBar" parent="Theme.AppCompat.Light.NoActionBar" />  
</resources>  
```


values-19/styles.xml
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
  
        // Add below code
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

