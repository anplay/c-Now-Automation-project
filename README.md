# c-Now - Automation project
## Tech stack:
- Java 8 ([Install docs](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html))
- Maven ([Install docs](https://maven.apache.org/install.html))
- Appium ([Install docs](https://appium.io/docs/en/about-appium/intro/#appium-concepts))
- JUnit (Will be installed automatically)
- Please see pom.xml file for more details on application modules
- Create ```build/logs``` directory into project folder.

## Features
- Application could be found and downloaded [here](https://github.com/anplay/c-Now-Automation-project)
  


## How to set environment for running tests
Before executing tests there should be set next software:
- Android SDK and tools ([Install docs](https://developer.android.com/studio/index.html))
- Node.js with NPM ([Install docs](https://nodejs.org/en/download/))
- Appium server ([Install docs](https://appium.io/docs/en/about-appium/intro/#appium-concepts))

<b>[Important]</b> 

All the paths for libraries should be added to ```PATH``` system environment variable and to ```~/.bash_profile```:
- ANDROID_HOME
- APPIUM_HOME
- NODE_HOME


#### Tests parameters

##mobile platform
- mobile.platform= (f.e.: Android/iOS)
- os.version=

##device config
- device.id= (f.e.: FA53LYJ13663)
- device.name=


### Source code
Source code (git repo) is available at ```https://github.com/anplay/c-Now-Automation-project```

### Assumptions
- You already familiar with: Git, Java, Terminal/Command line implementation of your Operation System
- Application code will be located in (Unix): ```~/Projects``` or in (Windows) ```C:\Projects```

Use this command to download code base
```bash
cd PROJECT_DIR
git clone https://github.com/anplay/c-Now-Automation-project.git
```

Open terminal (Unix) or CMD prompt (MS Windows) and run following commands:
```bash
cd PROJECT_DIR
git pull
```
<br>

## Run tests

For MacOS/Linux/Windows platform:

To execute UI tests -
```
mvn clean test
```

## Reports and logs

JUnit XML report will be generated in ```target/surefire-reports``` directory.
All the Appium logs will be saved in ```build/logs``` directory.