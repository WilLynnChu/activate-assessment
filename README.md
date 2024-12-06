# Setting up the environment

#### Installing Java

##### 1. Install [Java](https://www.oracle.com/java/technologies/downloads/?er=221886)
##### 2. Add the path into your bash profile
```
JAVA_HOME="<path_to_java>/bin"
```
##### 3. Check if Java installed and path exported successfully
```
java -version
```
#### Installing Maven
##### 4. Install [Maven](https://maven.apache.org/download.cgi)
##### 5. Add the path into your bash profile
```
export M2_HOME=<path_to_maven>
export PATH=$PATH:/<path_to_maven>/bin
```
##### 6. Dependencies will be managed in maven dependencies and auto download and add the JAR file to Java path.
#### Installing Eclipse
##### 7. Install [Eclipse](https://www.eclipse.org/downloads/)
#### Installing TestNG plugin in Eclipse
##### 8. Copy Online Update-Site link for latest release
##### 9. In Eclipse, go to Help > Install new software
##### 10. In install software window, click Work with > Add/
##### 11. Go to [TestNG plugin](https://github.com/testng-team/testng-eclipse)
##### 12. Set name as TestNG, and set URL as Online Update-Site link copied in step 8
##### 13. Wait for it to install, click accept/agree if needed
##### 14. Restart Eclipse

# To execute test suite created:
##### 1. Open project with Eclipse
##### 2. Right click run_all.xml and run as TestNG
##### 3. Or you can run the individual file in test-cases folder

# Test Reports
##### It will be stored in test-output folder
