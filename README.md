Table of Contents
About the Project
Built With
Getting Started
Prerequisites
Installation
Usage
Reports
About the Project
Playwright Selenium with Java- Hudl Login scenario - This project is based on Microsoft Playwright which enables reliable end-to-end testing for modern web apps.

Top Features:

Easy to Configure.
Auto-waits for all the relevant checks to pass and only then performs the requested action.
Records the test script and every action on the target page is turned into generated script.
Generates trace file on failure, which gives in-depth details of Test Case execution.
Execution of test case is faster when compared with other competitive framework in market.
Supports Headful/Headless mode execution for Firefox/Webkit/Google Chrome/Chromium/MS Edge on Windows/Linux/Mac machines.
Rerun Failed Test cases
Supports 'download' event monitoring, so there is no need for user to actually wait for downloads to finish.
Supports Serial and Parallel execution.
Spark PDF/HTML Reports are generated after execution with an option to capture screenshot/video/trace file on failure.
Nonetheless Support from Microsoft so FREQUENT RELEASES and turn around time for any queries is 48 hours.
Built With
Playwright
Cucumber
JUnit
Maven
OpenJDK
Getting Started
Prerequisites
The following software are required:

java : Download and Install java 1.8
https://www.openlogic.com/openjdk-downloads
Maven must be configured
Installation
Clone the repo using below URL
https://github.com/akshayp7/playwright-typescipt-playwright-test.git
Navigate to folder and install dependencies using:
mvn clean install
Usage
For Browser Configuration, change required value in browser and headless mode in src/test/resources/config/config.properties.
For executing test cases in parallel, navigate to pom.xml and in plugin in configuration section provide <skipTests>false</skipTests> Now if you want to run 4 features in parallel provide <threadCount>4</threadCount> in maven-failsafe-plugin section in pom.xml and execute below command
mvn verify
For executing test cases in sequence, provide a suitable tag @smoke at the start of your scenario and execute below command:
mvn test "-Dcucumber. options=--tags @smoke"

For recording test scripts execute below command with desired url:
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://demoqa.com/"

For HTML Report configuration navigate to src/test/resources/extent.properties and provide destination folder as value in extent.reporter.spark.out
For PDF Report configuration navigate to src/test/resources/extent.properties and provide destination folder as value in extent.reporter.pdf.out
Screenshots and Trace files will be generated in target folder on failure this configuration is provided in src/test/java/hooks/Hooks.java in takeScreenshotAndTrace method.
To change your username go to src/test/resources/config/config.properties and provide value against adminUsername
To change password, go to src/main/java/utils/WebActions.java in encrypt() and replace yourPassword with your password, execute the test case, Encrypted password will be printed on your console . Copy Encrypted password in src/test/resources/config/config.properties against adminPassword field.
You can even execute test cases by running src/test/java/testrunner/TestRunner.java file all the failed test cases are saved in target/rerun.txt
For rerunning failed test cases run src/test/java/testrunner/ReRunner.java
Reports will be generated in target/HTMLReport and target/PdfReport folders.
Reports
Overall Report Overall Report Screenshot
![image (44)](https://github.com/pkchat55/hudlUI/assets/48479206/f569eb97-fd5f-4652-a4f7-b4c00b3c114f)


Failure Report Failure Report Screenshot
![image (45)](https://github.com/pkchat55/hudlUI/assets/48479206/fb79133f-4cfd-4d71-abbb-6e1f7d4a50f8)

PDF Report PDF Report Screenshot
![image (42)](https://github.com/pkchat55/hudlUI/assets/48479206/7e9af120-bf2b-480c-a677-898f0560492c)
![image (43)](https://github.com/pkchat55/hudlUI/assets/48479206/c6415da7-8dc9-427d-b8f4-b8b54706e650)

