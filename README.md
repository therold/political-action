# Political Action

#### _An application to track US congressional activity, 11/18/2016_

#### By _**Timothy Herold**_

## Description

_This application is designed to allow users to track the voting activity of congress. This application will also allow users to view the personal details of congressmen and senators._

## Minimum goals:
* _Allow a user to search for the congressperson and senators for their home address._
* _Allow a user to view personal details for congressmen and senators._
* _Allow a user to view how their congressperson and senators voted on previous bills._
* _Allow a user to view how other congressmen and senators have voted on previous bills._
_All of the above can be accomplished with the [Sunlight Congress API](https://sunlightlabs.github.io/congress/)._

## Stretch goals:
* _Allow a user to view donor information about senators and congressmen. [OpenSecrets API](https://www.opensecrets.org/resources/create/apis.php)
* _Allow a user to view volunteer opportunities in their area. [VolunteerMatch API](https://www.volunteermatch.org/legal/publicuseapi)_

## Setup/Installation Requirements

* Clone project from GitHub:
  * git clone https://github.com/therold/political-action.git
* Open Android Studio.
* Select "Open an existing Android Studio project".
* In the file browser dialog, navigate to the political-action directory and click "OK".

To run the application from Android Studio:
  * Click on the "Run" button on the toolbar, or press Shift-F10.
  * Select your Android device in the Deployment Target dialog.
  * Android Studio will automatically build the application and run it on your selected Android device.

To build and install the application from Android studio:
  * Click on Build -> Build APK.
  * This will generate an installable APK package in political-action/app/build/outputs/apk/app-debug.apk. Copy this file to your Android device.
  * On your Android device, enable the ability to [install applications from unknown sources](https://developer.android.com/distribute/tools/open-distribution.html#unknown-sources) if you have not done so already.
  * Open the file manager on your Android device and select app-debug.apk.
  * Follow the dialog prompts to install the application on your Android device.

## Technologies Used

* _Java_
* _Android_
* _Android Studio_

### License

*GPL*

Copyright (c) 2016 **_Timothy Herold_**
