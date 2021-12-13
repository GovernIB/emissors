@echo off

type help.txt

cmd /C mvn -DskipTests %* install
