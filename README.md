# directorySearchEngine

## Building the application

To build the  application , run:

    mvn clean install

After this command the application jar will be created in target folder named searchengine-1.0-SNAPSHOT.jar
To start your application , simply run:
   ```
   java -jar searchengine-1.0-SNAPSHOT.jar <Directory Name Containing text files>
   ```

   The sample  for a simple search scenerio as follows,below first keyword is "process" and in test.txt file it is found, then the letter "a" is searched and it is found in two files.
   
   ```
   Turkmens-MacBook-Pro:target turkmenmustafademirci$ java -jar searchengine-1.0-SNAPSHOT.jar /Users/turkmenmustafademirci/files
   Cache initialized.....
   search> process
   {test.txt=100}
   search> a
   {test.txt=100, test copy.txt=100}
   search>
   ```


