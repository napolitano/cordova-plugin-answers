# Cordova Answers Plugin for iOS and Android (iOS and Android)

__This plugin is not longer maintained.__

## Installation

1) Make sure that you have [Node](http://nodejs.org/) and [Cordova CLI](https://github.com/apache/cordova-cli) or [PhoneGap's CLI](https://github.com/mwbrooks/phonegap-cli) installed on your machine.

2) Add Answers plugin (IDE plugin) to the Android / iOS project
https://www.crashlytics.com/downloads

3) Follow instruction of chosen IDE-Plugin from Crashlytics / Fabric.

4) Add a plugin to your project using Cordova CLI:

```bash
cordova plugin add https://github.com/napolitano/cordova-plugin-answers
```
Or using PhoneGap CLI:

```bash
phonegap local plugin add https://github.com/napolitano/cordova-plugin-answers
```

## Usage

```js
answersPlugin.sendSignUp();
```

```js
answersPlugin.sendLogIn();
```

```js
answersPlugin.sendContentView(name, type, id, attributes);
```

```js
answersPlugin.sendCustomEvent(name, attributes);
```

## Methods

### sendSignUp() - iOS, Android
Allows you to see users signing up for your app in real-time,

### sendLogIn() - iOS, Android
Allows you to see users logging into your app in real-time

### sendContentView(name, type, id, attributes) - iOS, Android
Allows you to see users viewing content within your app in real-time and understand what content is most engaging.

All parameters are optional. However it is recommended to provide at least name, type and id

### sendCustomEvent(name, attributes) - iOS, Android
Send a custom event. All parameters are optional. 

### Supported Platforms

- Android
- iOS


### Basic example: Send everything which was send to console.log to Answers

```js
console.log = logToAnswers;

var logToAnswers = function () {
    for (var i = 0; i < arguments.length; i++) {
        answersPlugin.sendContentView(arguments[i], 'Log Message');
    }
}
```

## Credits

- Román A. Sarria - https://github.com/sarriaroman
- Francesco Verheye - https://github.com/verheyefrancesco
