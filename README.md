Java Framework for Selenium Webriver with Cucumber
==================================================

This Java Framework contains often used functionalities such as easy screenshots, automatic extent html reporting and custom smartwaits that are often needed for testing webapplications.


This document provides instruction on how to setup this framework on your local machine. There is a [**Help**](#markdown-header-help) section at the bottom to answer the FAQ's. Any suggestions to improve this document are most welcome.

## Download & Install:

- Java IDE: [IntelliJ community edition](https://www.jetbrains.com/idea/download/#section=windows)
- Chrome Plugin: [CSS Selector Helper for Chrome](https://chrome.google.com/webstore/detail/css-selector-helper-for-c/gddgceinofapfodcekopkjjelkbjodin)
- [Git](https://git-scm.com)
- [Java jdk](http://www.oracle.com/technetwork/java/javase/downloads/index.html)


## Setup

- Start up IntelliJ
- Choose 'Check out from Version Control' -> Git
- Fill in URL "https://github.com/MazinInaad/automationFramework.git"
- Press Clone
- When the following pop-up comes up select 'No': 

![versioncontrolcheckoutdone](https://user-images.githubusercontent.com/15871496/39982468-bf4640f6-5754-11e8-9c71-2c9970159400.png)   

- In your windows browser, create a pom.xml file from the pom.xml.example file in the main folder. Edit the xml elements on lines 5 and 8 to the name of your project.
- In IntelliJ, Select 'Open' project and browse to the test project folder you just created and open the folder
- If it is your first IntelliJ project then in IntelliJ:
    - Open project structure (CTRL + Shift + Alt + S), navigate to the 'Project' tab, choose new in Project SDK section, select JDK and direct to your java/jdk folder
    - Open Settings (CTRL + ALT + S), navigate to 'Plugins' and install the plugins: Gherkin and Cucumber for Java
- Create a browser.properties file from the browser.properties.example file in the main folder. 
- **Important** As you can see in browser.properties you can define which environment you want to run the test in.
  For the framework to work you also need to have a {environment}.properties file (for example ont.properties) in the folder **src/test/config** with at least a **url** property.
  You can use the **template.properties** file already available in the folder as an example.
- Browse to the folder: **src/test/java/com/project**. **In this folder you can create a new git for your own project**.
  This is the folder in which the project related Java files will be created. So your
  feature files (folder "features"), steps files (folder "steps"), pages (folder "pages") etc should be in this folder in their own respective subfolders.

  
## FrameWork setup
The framework has been setup such that generic Java classes such as the WebDrivers for 
different webbrowsers and mobile emulators are in this shared repository. It also has some
resource classes such as OurAssertions and OurScenario which consist of static methods which
can be used by any other class without initializing them.
The resource folder also includes some generic classes such as IgnoreCaseMaps and IgnoreSymbolsMap.


The idea of this framework is that the generic files which are supportive to all projects are saved within 
this framework and that the specific files which are for a specific project can be placed within
the src/test/java/com/project folder (Hereafter referred to as project folder). This folder is ignored in the .gitignore of the
framework repo. However, the user can place this folder in his own git repo for his/her project.

The [TA Guidelines](TAGuidelines.md) document gives more indepth information on how to setup your own project using this framework.

## Reporting test results
Once you have created your features, you can run all the tests from the AppTest class (src/test/java/com/project/AppTests.java).
This will run all your scenarios and create screenshots in the **screenshots** folder and a nice html report in the **reports** folder.


If you only want to run specific testcases, you can add a tag above the scenario name (see [this tutorial on tags](http://toolsqa.com/cucumber/cucumber-tags/) for more information) and edit the commented line ```tags = {"@selection"},``` in AppTest.java.

## Help

### git bash here 
Git Bash can be accessed by right mouse clicking in the folder in which you want to run the git command. 

### Setting (global) proxy for git
- Set proxy settings for git (git bash anywhere):
```git
git config --global http.proxy http://@<proxyserver>:<port>
```  

### Turn off ssl validation
- Use this only if you are familiar with the project source you are tyring to check out:
```git  
git config --global http.sslVerify false
git clone <git repository> .
git config --global --unset http.sslVerify
git config http.sslVerify false
```


If you have any questions please feel free to contact me: mazin.inaad@capgemini.com
