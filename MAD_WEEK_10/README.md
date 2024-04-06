### Registration form

- Create a new project in **Android Studio** named <font color="red">Registration Form</font> (name should me absolute because in [`MainActivity.java`]() the imported package name is **registrationform**)
- Add the belo `XML` code in `activity_main.xml` of your project.
```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- The root layout for the activity, using ConstraintLayout to manage UI components -->
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

<!-- ScrollView to enable scrolling if the content exceeds the screen height -->
    <ScrollView
        android:layout_width="409dp"
        android:layout_height="729dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">
<!-- LinearLayout to stack UI elements vertically -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
    <!-- TextView to display the title "Registration Form" -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Registration Form"
                android:textAlignment="center"
                android:layout_margin="10dp"
                android:textSize="30dp" />
<!-- LinearLayout to arrange Username TextView and EditText horizontally -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
    <!-- TextView for "Username" label -->
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Username : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
    <!-- EditText for user input -->
                <EditText
                    android:id="@+id/userName"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Enter Username" />
            </LinearLayout>
<!-- Similar LinearLayouts for Password and Confirm Password -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Password : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/pwd"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:ems="10"
                    android:hint="Enter Password"
                    android:layout_margin="10dp"
                    android:inputType="textPassword" />
            </LinearLayout>
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="40dp"
                    android:text="Confirm\nPassword "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/confirm"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Confirm Password" />
            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Address : "
                    android:layout_margin="10dp"
                    android:textAlignment="center"
                    />
                <EditText
                    android:id="@+id/address"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Enter address here" />
            </LinearLayout>
<!-- LinearLayout to arrange Gender TextView and RadioButtons horizontally -->
            <LinearLayout
                android:layout_width="300dp"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_marginStart="20dp">
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:layout_margin="10dp"
                    android:textAlignment="center"
                    android:text="Gender : " />
    <!-- LinearLayout to arrange RadioButtons for Male and Female -->
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="horizontal"
                    android:layout_marginStart="40dp">
                    <RadioButton
                        android:layout_width="100dp"
                        android:layout_height="40dp"
                        android:text="Male" />
                    <RadioButton
                        android:layout_width="100dp"
                        android:layout_height="40dp"
                        android:text="Female" />
                </LinearLayout>
            </LinearLayout>
<!-- LinearLayout for Date of Birth section -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:layout_margin="20dp"
                android:textAlignment="center">
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="30dp"
                    android:textAlignment="center"
                    android:text="Date of Birth" />
                <Button
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:text="Select Date"
                    android:id="@+id/dateButton" />
                <DatePicker
                    android:id="@+id/datePicker"
                    android:layout_width="match_parent"
                    android:layout_height="400dp"
                    android:layout_margin="10dp"
                    android:visibility="gone" />
            </LinearLayout>
<!-- LinearLayout for Age section -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Age : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/age"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:ems="10"
                    android:inputType="number"
                    android:layout_margin="10dp"
                    android:hint="Enter age here" />
            </LinearLayout>
<!-- LinearLayout for State selection Spinner -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_margin="10dp">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="State : "
                    android:textAlignment="center" />
                <Spinner
                    android:layout_width="150dp"
                    android:layout_height="50dp"
                    android:layout_marginStart="25dp"
                    android:id="@+id/countries" />
            </LinearLayout>
<!-- Button to submit the form -->
            <Button
                android:id="@+id/submit"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Submit" />
<!-- TextView to display the output or preview -->
            <TextView
                android:id="@+id/output"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:textAlignment="textStart"
                android:layout_margin="30dp"
                android:hint="Preview" />
        </LinearLayout>
    </ScrollView>
</androidx.constraintlayout.widget.ConstraintLayout>
```
