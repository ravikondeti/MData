$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login_Test.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Successful login with valid credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "user is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user navigate to log in page",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user enter credentials to login",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 6
    },
    {
      "cells": [
        "ravi.kondeti@gmail.com",
        "Paraiah@200186"
      ],
      "line": 7
    },
    {
      "cells": [
        "ravi.kondeti01@gmail.com",
        "paraiah"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "message displayed login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTest.user_is_on_home_page()"
});
formatter.result({
  "duration": 4859813024,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_navigate_to_log_in_page()"
});
formatter.result({
  "duration": 2137071852,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_enter_credentials_to_login(Credentials\u003e)"
});
formatter.result({
  "duration": 13165489923,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: #email\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:49:13 -0700\u0027\nSystem info: host: \u0027Mr-PC\u0027, ip: \u0027192.168.0.11\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_102\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{rotatable\u003dfalse, raisesAccessibilityExceptions\u003dfalse, marionette\u003dtrue, firefoxOptions\u003d{args\u003d[], prefs\u003d{}}, appBuildId\u003d20161019084923, moz:firefoxOptions\u003d{args\u003d[], prefs\u003d{}}, version\u003d, platform\u003dXP, proxy\u003d{}, command_id\u003d1, specificationLevel\u003d0, acceptSslCerts\u003dfalse, processId\u003d1212, browserVersion\u003d49.0.2, platformVersion\u003d6.1, XULappId\u003d{ec8030f7-c20a-464f-9b0e-13a3a9e97384}, browserName\u003dfirefox, takesScreenshot\u003dtrue, takesElementScreenshot\u003dtrue, platformName\u003dwindows_nt, device\u003ddesktop}]\nSession ID: 2dff0bb3-595e-444d-b08d-4f722307da43\n*** Element info: {Using\u003did, value\u003demail}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:127)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:93)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:42)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:163)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:417)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat stepdefinition.LoginTest.user_enter_credentials_to_login(LoginTest.java:53)\r\n\tat ✽.And user enter credentials to login(Login_Test.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginTest.message_displayed_login_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 12,
  "name": "Successful logout",
  "description": "",
  "id": "login-action;successful-logout",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "user log out from the appliation",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "message displayed logout successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTest.user_log_out_from_the_appliation()"
});
formatter.result({
  "duration": 3216067,
  "error_message": "java.lang.NullPointerException\r\n\tat stepdefinition.LoginTest.user_log_out_from_the_appliation(LoginTest.java:99)\r\n\tat ✽.When user log out from the appliation(Login_Test.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginTest.message_displayed_logout_successfully()"
});
formatter.result({
  "status": "skipped"
});
});