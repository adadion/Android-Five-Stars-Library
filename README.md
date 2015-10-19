#### Fork/Modified version of [Android-Five-Stars-Library](https://github.com/Angtrim/Android-Five-Stars-Library) by [Angtrim](https://github.com/Angtrim)

## Android Five Stars Library

Android Five Stars Library is a small library that helps developers add a **"Rate My App"** dialog to their applications.

It's called "Five Stars" because the dialog has a different behaviour based on the rating given by the user.

If the user gives **4 or 5 stars out of 5**, the user is sent through the positive intent.

If the user gives **3 or less stars out of 5**, the user is sent through the negative intent 


## Installation

To use the library, first include it your project using Gradle


    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
    }

	dependencies {
        compile 'com.github.saulmm:Android-Five-Stars-Library:v2.2'
	}


## How to use

```java
        Intent wellIntent = new Intent(Intent.ACTION_VIEW);
        wellIntent.setData(Uri.parse("http://www.google.com"));

        Intent badIntent = new Intent(Intent.ACTION_VIEW);
        wellIntent.setData(Uri.parse("http://www.yahoo.com"));

        FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this);
        fiveStarsDialog.rateText("Your custom text")
            .title("Your custom title")
            .wellRatingIntent(wellIntent)
            .badRatingIntent(badIntent)
            .show();
```
