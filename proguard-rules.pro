# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# database
-keep class net.sqlcipher.** { *; }
-keep class net.sqlcipher.database.* { *; }

# retrofit / okhttp
-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keep class okio.** { *; }
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.internal.platform.**
-dontwarn okio.**
-dontwarn org.conscrypt.**

-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
-dontwarn javax.annotation.concurrent.GuardedBy

# firebase crashlytics
-printmapping mapping.txt
-keepattributes *Annotation*,SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.google.firebase.crashlytics.** { *; }
-dontwarn com.google.firebase.crashlytics.**
-dontwarn com.google.firebase.messaging.**