# play-with-oracle

```
Assumptions
 A) You have Maven 3.6.3 or later installed      
 B) You have Java 17 JDK installed
 C) You have an Oracle Database Installed
 D) You have a tnsnames.ora file that contains a SID called "ORCL"
 E) You have set an environment variable:  TNS_ADMIN
      TNS_ADMIN must point to the directory that contains your tnsnames.ora 
    The Oracle driver needs TNS_ADMIN set if you use the SID to connect to your database
     
      

Approach 1:  Nuke your oracle database  using the maven plugin (on command-line) 
--------------------------------------------------------------------------------
Follow these steps erase and rebuild your Oracle database from command-line
 1. Set your environment variable:
      TNS_ADMIN points to the directory that holds the tnsnames.ora -- e.g., c:\tools\oracle_home\network\admin

 2. Verify that you have a tnsnames.ora file in the TNS_ADMIN directory

 3. Clone this project
    terminal> git clone https://github.com/traderres/play-with-oracle.git
    terminal> cd play-with-oracle

 4. Update the pom.xml flyway-maven-plugin configuration:
    (if needed)

        <configuration>
          <!-- Set the Oracle credentials when running mvn flyway:migrate from command-line -->
          <!-- NOTE:  The TNS_ADMIN environment variable must point to the directory where tnsnames.ora is to use the ORCL sid  -->
          <user>test_user</user>
          <password>secret</password>
          <url>jdbc:oracle:thin:@ORCL</url>
        </configuration>


 5. Use maven to nuke your database
    terminal> mvn flyway:clean
    terminal> mvn flyway:migrate



Approach 2:  Nuke your oracle database by running the compiled Java JAR 
-----------------------------------------------------------------------
 1. Edit the src/main/resources/application.yaml
    -- Adjust the app.datasource section

 2. Compile the java JAR
    terminal> mvn clean package

 3. Run the java JAR to tell flyway to run clean and migrate
    terminal> java -Dapp.datasource.flyway-clean-on-startup=TRUE -jar ./target/play-with-oracle-1.0-SNAPSHOT-exec.jar



Approach 3:  Nuke your database from IntelliJ (with a one-click debug option)
-----------------------------------------------------------------------------
Follow these steps to use IntelliJ to erase and rebuild your Oracle database
 1. Clone this project
    terminal> git clone https://github.com/traderres/play-with-oracle.git

 2. Start IntelliJ

 3. Open the play-with-oracle/ project

 4. Go to play-with-oracle/src/main/java/org/example/App 

 5. Right-click on App.java -> Debug
    -- This will create a debug entry in your IntelliJ

 6. Pull Run -> Edit Configurations
    a. Put the cursor on "App" and press Control-D  (to duplicate it)
  
    b. Rename the duplicate entry to "Nuke Database"
 
    c. Select Modify Option -> Add VM Option
       In the VM Options textbox, insert this:
          -Dapp.datasource.flyway-clean-on-startup=TRUE
          
    d. Press "OK"

 7. Select Nuke Database and press Play or Debug
    -- It should erase and rebuild your oracle database
 
```
