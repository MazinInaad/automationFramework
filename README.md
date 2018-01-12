Cucumber-Java-Selenium
==================

## Installation

Download&Install:

- [IntelliJ community edition] (https://www.jetbrains.com/idea/download/#section=windows)
- Chrome Plugin: [CSS Selector Helper for Chrome] (https://chrome.google.com/webstore/detail/css-selector-helper-for-c/gddgceinofapfodcekopkjjelkbjodin)
- [git] (https://git-scm.com)
- java jdk (not jre)

### Specific instructions for installing and setting up on DVOM Dev_account
- Set proxy settings for git (git bash anywhere):
```git
git config --global http.proxy http://@proxy.org.om.local:8080
no_proxy=.org.om.local
```  
- Set proxy settings for IntelliJ: File, Settings, System Settings, HTTP Proxy.

- When cloning a project from the OM bitbucket (at the end of the Setup instructions below) the following steps are necessary:
```git  
git config --global http.sslVerify false
git clone <OM Bitbucket repository> .
git config --global --unset http.sslVerify
git config http.sslVerify false
```

## Setup

- Create Folder for test project and type in the following command in [git bash here]. 
  **Please note:** Each account has a unique command since you have to give your username in the command.
  This command can also be found at the top of your bitbucket page.
  You now have the generic test automation framework.
  
  **Important: the ' .' at the end insures that it is cloned into the current file and not to a subfile.**
    
    git clone https://<username>@bitbucket.org/mazin_inaad/automatedtests.git .
    
- Start up IntelliJ
- If it is your first IntelliJ project then in IntelliJ:
    - Select 'Open' project and browse to the test project folder you just created and open the folder
    - open project structure (CTRL + Shift + Alt + S)
    - project tab
    - choose new in Project SDK section, select JDK and direct to your java/jdk folder
    - install plugins: gherkin, cucumber
- Create a browser.properties file from the browser.properties.example file in the main folder.
- Browse to the folder: **src/test/java/com/project**.
  This is the folder in which the project related Java files will be created. So your
  feature files, steps files, pages etc should be in this folder in their own respective subfolders.
  **In this folder you can create a new git for your own project**.
  
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

In the project folder it is best to create subfolders for your feature files (named 'features') and steps (named steps).
Furthermore, it is good practice to create a folder for your pages.

##Help

[git bash here] Git Bash can be accessed by right mouse clicking in the folder in which you want to run the git cammand. 

If you have any questions please feel free to contact me: mazin.inaad@capgemini.com
