# play-with-oracle

<pre>
Assumptions
 A) You have Maven 3.6.3 or later installed      
 B) You have Java 17 JDK installed
 C) You have an Oracle Database Installed
 D) You have a tnsnames.ora file that contains a SID called "ORCL"


Nuke your database using the command-line
-----------------------------------------
Follow these steps erase and rebuild your Oracle database from command-line
 1. Set your environment variable:
      TNS_ADMIN points to the directory that holds the tnsnames.ora -- e.g., c:\tools\oracle_home\network\admin

 2. Verify that you have a tnsnames.ora file in the TNS_ADMIN directory

 3. Use maven to nuke your database
    terminal> mvn flyway:clean
    terminal> mvn flyway:migrate


Nuke your database from IntelliJ (with a one-click debug option)
----------------------------------------------------------------
Follow these steps to use IntelliJ to erase and rebuild your Oracle database
 1. Clone this project

 2. Go to play-with-oracle/src/main/java/org/example/App 

 3. Right-click on App.java -> Debug
    -- This will create a debug entry in your IntelliJ

 4. Pull Run -> Edit Configurations
    a. Put the cursor on "App" and press Control-D  (to duplicate it)
  
    b. Rename the duplicate entry to "Nuke Database"
 
    c. Press "Add VM Option" and add this entry
        -Dflyway-clean-on-startup=TRUE
    d. Press "OK"

 5. Select Nuke Database and press Play or Debug
    -- It should erase and rebuild your oracle database
 
