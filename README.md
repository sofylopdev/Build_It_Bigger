# Build_It_Bigger

Fifth Project for the Android Nanodegree


## Project Overview

In this project, you will create an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules:

 1. A Java library that provides jokes
 2. A Google Cloud Endpoints (GCE) project that serves those jokes
 3. An Android Library containing an activity for displaying jokes
 4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display
 
When you're done, your multi-project build will look something like this:

![alt text](https://github.com/sofylopdev/Build_It_Bigger/blob/master/jokes_app_logic.png)


## Why this Project?

As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.


## What Will I Learn?

You will learn the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. You'll learn to:

 - Add free and paid flavors to an app, and set up your build to share code between them
 - Factor reusable functionality into a Java library
 - Factor reusable Android functionality into an Android library
 - Configure a multi-project build to compile your libraries and app
 - Use the Gradle App Engine plugin to deploy a backend
 - Configure an integration test suite that runs against the local App Engine development server


## Implemented Required Tasks

 - Create a Java library
 - Create an Android Library
 - Setup GCE
 - Add Functional Tests
 - Add a Paid Flavor


## Implemented Optional Tasks 

 - Add Interstitial Ad
 - Add Loading Indicator
 - Configure Test Task (To tie it all together, create a Gradle task that:
 
                       1. Launches the GCE local development server;
                       2. Runs all tests;
                       3. Shuts the server down again
                       
 )


## Screenshots

|InitialPage| InterstitialAd | JokeDisplay |
| --- | --- | --- |
| ![alt text](https://github.com/sofylopdev/Build_It_Bigger/blob/master/InitialPage.png) | ![alt text](https://github.com/sofylopdev/Build_It_Bigger/blob/master/InterstitialAd.png) | ![alt text](https://github.com/sofylopdev/Build_It_Bigger/blob/master/JokeDisplay.png) | 


## License

http://www.apache.org/licenses/LICENSE-2.0
                       

