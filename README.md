cucumber-java-selenium
==================

## Installation
Download&Install:
- IntelliJ community edition
- Chrome Plugin: CSS Selector Helper for Chrome
- git (https://git-scm.com)
- java jdk (not jre)

## Setup

- Create Folder for test project and type in command (git bash here): <br> 
  git clone https://mazin_inaad@bitbucket.org/mazin_inaad/automatedtests.git . <br>
  You now have the generic test automation framework.
  #####NOTE: the ' .' at the end insures that it is cloned into the current file and not to a subfile.  
- Start up IntelliJ
- If it is your first IntelliJ project then in IntelliJ:
    - open project structure (CTRL + Shift + Alt + S)
    - project tab
    - choose new in Project SDK section, select JDK and direct to your java/jdk folder
    - install plugins: gherkin, cucumber

  
- Browse to the folder: <b>src/test/java/com/project</b>.
  This is the folder in which the project related Java files will be created. So your
  feature files, steps files, pages etc should be in this folder in their own respective subfolders.
  ######In this folder you can create a new git for your own project.
  
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
If you have any questions please feel free to contact me: mazin.inaad@capgemini.com




