@echo off
title Antivirus
echo Antivirus
echo created by the ApplicationName
:start
IF EXIST virusTest.txt goto infected
IF NOT EXIST virusTest.txt goto clean
cd D:\PRANAV
:infected
echo WARNING VIRUS DETECTED!
pause
goto start
:clean
echo System secure!
pause
exit