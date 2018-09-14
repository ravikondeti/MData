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
  "duration": 40071056050,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_navigate_to_log_in_page()"
});
formatter.result({
  "duration": 10881172611,
  "error_message": "org.openqa.selenium.UnsupportedCommandException: timeouts\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:49:13 -0700\u0027\nSystem info: host: \u0027Mr-PC\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{moz:profile\u003dC:\\Users\\Mr\\AppData\\Local\\Temp\\rust_mozprofile.eX8GrpqNoyOT, rotatable\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, pageLoadStrategy\u003dnormal, moz:headless\u003dfalse, platform\u003dANY, moz:accessibilityChecks\u003dfalse, moz:useNonSpecCompliantPointerOrigin\u003dfalse, acceptInsecureCerts\u003dfalse, browserVersion\u003d59.0.1, platformVersion\u003d6.1, moz:processID\u003d2544, browserName\u003dfirefox, platformName\u003dwindows_nt, moz:webdriverClick\u003dtrue}]\nSession ID: 5c4dbcec-85f1-44ca-94cd-75c3f8f25bdb\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:127)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:93)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:42)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:163)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver.access$100(FirefoxDriver.java:70)\r\n\tat org.openqa.selenium.firefox.FirefoxDriver$1$1.implicitlyWait(FirefoxDriver.java:302)\r\n\tat stepdefinition.LoginTest.user_navigate_to_log_in_page(LoginTest.java:45)\r\n\tat ✽.When user navigate to log in page(Login_Test.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginTest.user_enter_credentials_to_login(Credentials\u003e)"
});
formatter.result({
  "status": "skipped"
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
  "duration": 49539999,
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