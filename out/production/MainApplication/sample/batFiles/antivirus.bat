@echo off
title Antivirus
echo Antivirus
echo created by the ApplicationName
:start
cd D:\PRANAV
IF EXIST virusTest.txt goto infected
IF NOT EXIST virusTest.txt goto clean
:infected
echo WARNING VIRUS DETECTED!
echo Do you want to delete this virus?(Y,N)
set INPUT=
set /P INPUT=Type input: %=%
If /I "%INPUT%"=="y" goto yesDelete
If /I "%INPUT%"=="n" goto no
echo Incorrect input & goto infected
:yesDelete
del virusTest.txt
goto start
:no
echo Are you sure you don't want to delete this file?
set INPUT=
set /P INPUT=Type input: %=%
If /I "%INPUT%"=="y" goto cleanAlternative
If /I "%INPUT%"=="n" goto yesDelete
:clean
echo System secure!
goto end
:cleanAlternative
echo System not secure
:end
pause
exit