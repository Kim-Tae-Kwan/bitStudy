@echo off
set filename=Ex04
set /p filename = filename :
del %filename%.class
javac %filename%.java
java %filename%