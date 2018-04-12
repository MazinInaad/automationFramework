Java Framework for Selenium Webriver with Cucumber
==================================================

This document provides instruction on how to setup this framework on your local machine. There is a [**Help**](#markdown-header-help) section at the bottom to answer the FAQ's. Any suggestions to improve this document are most welcome.

## Download & Install:

- Java IDE: [IntelliJ community edition](https://www.jetbrains.com/idea/download/#section=windows)
- Chrome Plugin: [CSS Selector Helper for Chrome](https://chrome.google.com/webstore/detail/css-selector-helper-for-c/gddgceinofapfodcekopkjjelkbjodin)
- [Git](https://git-scm.com)
- Java jdk: [windows64](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)


## Setup

- Create a folder for your test project and type in the following command in [git bash here](#markdown-header-git-bash-here). 
  **Please note:** Each account has a unique command since you have to give your username in the command.
  This command can also be found at the top of this bitbucket page.
  You now have the generic test automation framework.
  
  **Important: the ' .' at the end insures that it is cloned into the current file and not to a subfile.**
    
    git clone https://<username>@bitbucket.org/mazin_inaad/automatedtests.git .
    
- Create a pom.xml file from the pom.xml.example file in the main folder. Edit the xml elements on lines 5 and 8 to the name of your project.
- Start up IntelliJ
- If it is your first IntelliJ project then in IntelliJ:
    - Select 'Open' project and browse to the test project folder you just created and open the folder
    - Open project structure (CTRL + Shift + Alt + S), navigate to the 'Project' tab, choose new in Project SDK section, select JDK and direct to your java/jdk folder
    - Open Settings (CTRL + ALT + S), navigate to 'Plugins' and install the plugins: Gherkin and Cucumber for Java
- Create a browser.properties file from the browser.properties.example file in the main folder. 
- Browse to the folder: **src/test/java/com/** and create a folder named  **project**. **In this folder you can create a new git for your own project**.
  This is the folder in which the project related Java files will be created. So your
  feature files (folder "features"), steps files (folder "steps"), pages (folder "pages") etc should be in this folder in their own respective subfolders.
- **Important** For the framework to work you also need to have a {environment}.properties file (for example ont.properties) in the folder **project/resources/config** with at least a **url** property.
  For more information see the template in **capgemini/resources/config/template.properties**
  
  
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

## Help

### git bash here 
Git Bash can be accessed by right mouse clicking in the folder in which you want to run the git command. 

### Setting (global) proxy for git
- Set proxy settings for git (git bash anywhere):
```git
git config --global http.proxy http://@proxy.org.om.local:8080
```  

### Accessing DVOM Bitbucket
- When cloning a project from the DVOM bitbucket (at the end of the Setup instructions below) the following steps are necessary:
```git  
git config --global http.sslVerify false
git clone <OM Bitbucket repository> .
git config --global --unset http.sslVerify
git config http.sslVerify false
```


If you have any questions please feel free to contact me: mazin.inaad@capgemini.com
