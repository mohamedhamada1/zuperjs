# zuperjs


I have create JS interface to integrate with external JS file https://side-projects-files.s3.us-east-2.amazonaws.com/js/javascriptcode.js

main modules are 

1- di :- for depency injection. I know this is simple application and doesn't required DI but i just added it to show you
2- ui :- which contain everything related to UI and view model
3- utils:- which has Extensions class


How it works?

just after run the application you need to write operations numbers separate with ","

for example :- 1,2,3,4,5,6

the application will run all operations and update recycler view 



Important note

I have checked Java script file. you are using below line
window.webkit.messageHandlers.jumbo.postMessage() to post messages for native apps. this never work with me i have checked everywhere also. this line should work with IOS
for android we have to use  window.jumbo.postMessage() or jumbo.postMessage(). this point we need to discuss it in code review. I'm not sure if we can make it work for android and IOS
so i have update this line and use it like this window.jumbo.postMessage() which is working fine
please check below url for this point
https://firebase.google.com/docs/analytics/webview?platform=android
and 
https://developer.android.com/guide/webapps/webview.html


update JS file "just update postMesesage line "
https://side-projects-files.s3.us-east-2.amazonaws.com/js/javascriptcode.js

