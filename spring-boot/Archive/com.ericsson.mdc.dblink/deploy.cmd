cls
call mvn clean install
call copy application.properties .\target\application.properties
call java -jar target/dblink-1.0.0.jar