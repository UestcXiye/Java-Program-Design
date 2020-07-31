@echo off

javac -d classes src\edu\pku\tds\ui\*.java src\edu\pku\tds\util\*.java src\edu\pku\tds\*.java

java -cp classes edu.pku.tds.PackageTest

pause
