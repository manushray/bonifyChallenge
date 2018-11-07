# bonifyChallenge

#I have completed all the 3 Tasks mentioned in the Challenge,I have created a partial Automation Framework comprise of (Selenium+JAVA+Page Object Model+TestNG+Extent Report).
TASK 1: I have found 6 bugs (2 in bonify.de site & 4 in my.bonify.de) and mention those in Bugs_LIST.xslx file which has 2 sheet in it.(There were many performance related issues but I was not sure whether its the right place to file it so didnt attach the JMeter script)  
TASK 2 & TASK 3 I have writen it in 2 seperate class as per (Page object Model+TESTNG framework) standard.

#Task 2 Class names are(There are 8 Test Cases for each test cases I have mention it in the method itself but just for the idea I have cover following scenario New User validation, Existing User, Password Rule, Registration, Forget password, Imprint, Conditions, Data Protection, Logo of security partner): 
Main code is in :src/main/java/bonifyAppAutomation/bonifyAutomationApp/Pages/LoginPage.java
Test code is in :src/test/java/bonifyAppAutomation/bonifyAutomationApp/LoginPageTest.java

#Task 3 Class name are(There is 1 Scenario where I am switching into from normal page to 1 iframe to another iframe and then clicking the link and validating whether the clicked link is correct or not)
(Insurance > Liability Insurance > getSafe)
Main code is in:/src/main/java/bonifyAppAutomation/bonifyAutomationApp/Pages/FinancePage.java
Test code is in:/src/test/java/bonifyAppAutomation/bonifyAutomationApp/FinancePageTest.java

Prerequisites – SYSTEM SETUP

Java: v1.8 v)(if not installed use: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Eclipse

Maven:Apache Maven 3.5.4 , if its not installed please install from "https://maven.apache.org/install.html"

STEPS TO FOLLOW FOR EXECUTION OF CODE:

#Clone the code by using below command at your folder destination where you want the code. 
https://github.com/manushray/bonifyChallenge.git

#Open the Eclipse follow the below steps:

Click on the "File > Import "
Navigate to Maven > Existing Maven Projects & click on "Next".
Browse to the location of folder where you have clone the code & click on "Finish"
I have created a partial Automation Framework comprise of (Selenium+JAVA+Page Object Model+TestNG+Extent Report) where my "Base" class is Parent of all the classes which is present under package name "bonifyAppAutomation.bonifyAutomationApp.CodeBase"
Reading of config.properties , driver , selectin of browser type all these activities are done in "Base" Class
As I have made my code dynamic from where you can change the parameter and data set/Test Scneario by changing in the config.properties file which is present under package name "src/main/java/bonifyAppAutomation/bonifyAutomationApp/Configuration/"

You dont have to do any changes , just run the project as mention below(The full script runs in 2.66min so please dont kill the browser if it takes time to identify/load the page.


#Command Line Command:
go to the project folder and run the below command: mvn clean install

#Eclipse: 
Click on "Project > Run As > Maven test/Maven build....(goal > clean install)/Maven build"

Once Code will run , please refresh the project so that you can view the result either on eclipse console or in FinalExtentReport.html(this you have to view in Browser)this is for better reporint purpose.
