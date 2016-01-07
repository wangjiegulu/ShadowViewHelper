# ShadowViewHelper
Shadow layout, shadow view for android.

<img src='screenshot/shadow_a.png' height='500px'/>

# How to use：
`It's very simple to use.`
### Gradle:
```groovy
compile 'com.github.wangjiegulu:ShadowViewHelper:1.0.1'
```
### Maven:
```xml
<dependency>
    <groupId>com.github.wangjiegulu</groupId>
    <artifactId>ShadowViewHelper</artifactId>
    <version>1.0.1</version>
</dependency>
```
### xml:
```xml
<LinearLayout
      android:id="@+id/activity_main_shadow_view_b"
      android:layout_width="wrap_content" android:layout_height="wrap_content"
      android:layout_gravity="center"
      android:layout_marginTop="32dp"
      android:orientation="vertical"
      android:gravity="center"
      android:padding="8dp"
      >
      <ImageView android:layout_width="match_parent" android:layout_height="match_parent"
                 android:src="@mipmap/ic_launcher"
              />
      <TextView android:layout_width="match_parent" android:layout_height="match_parent"
                android:gravity="center"
                android:text="Shadow View with LinearLayout"
                android:textSize="15sp"
              />
</LinearLayout>
```
### Activity:
```java
ShadowViewHelper.bindShadowHelper(
    new ShadowProperty()
        .setShadowColor(0x77000000)
        .setShadowDy(ABTextUtil.dip2px(context, 0.5f))
        .setShadowRadius(ABTextUtil.dip2px(context, 3))
    , findViewById(R.id.activity_main_shadow_view_b));
```


License
=======

    Copyright 2015 Wang Jie

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ShadowViewHelper-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1884)
