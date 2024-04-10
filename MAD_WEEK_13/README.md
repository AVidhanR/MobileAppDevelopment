# Notification Concept

- Create a new project in **Android Studio** named **Colors Menu** (name should me absolute because in `MainActivity.java` the imported package name is **colorsmenu**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- RelativeLayout to organize views -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Toolbar for displaying menu options -->
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        app:title="Colors Menu"
        android:background="@color/black"
        app:titleTextColor="@color/white" />

</RelativeLayout>
```

- Now, in order to add a menu context; create a new **Android resource file** named `menu` under `res` directory.
- Create a new file named `main_menu.xml` in `menu` directory.
- Add the below code in `main_menu.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- In order to create a menu we use <menu></menu tag -->
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- Red color option -->
    <item
        android:id="@+id/redItem"
        android:title="Red" />

    <!-- Green color option -->
    <item
        android:id="@+id/greenItem"
        android:title="Green" />

    <!-- Blue color option -->
    <item
        android:id="@+id/blueItem"
        android:title="Blue" />

    <!-- Black color option -->
    <item
        android:id="@+id/blackItem"
        android:title="Black" />

    <!-- Reset color option -->
    <item
        android:id="@+id/whiteItem"
        android:title="Reset" />
</menu>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java

```

That's it now save the both files and run app!

> **Note** :make sure to check the package name in java file `package com.example.notificationconcept;` if you got another name other than `notificationconcept` make sure to replace the first line of the code with yours.
