@ECHO OFF
title FTP
ECHO ------------------------------------
ECHO 	 SSH - Components App
ECHO ------------------------------------
ECHO 	BY PRANAV and KEDAR
ECHO -------------------------------------
ECHO    Now a FTP would be initialised
ECHO -------------------------------------
ECHO    Go Ahead?(Y,N)
ECHO -------------------------------------
set INPUT=
set /P INPUT=Type input: %=%
If /I "%INPUT%"=="y" goto yes
If /I "%INPUT%"=="n" goto no
:yes
cd src\sample\FTP\bin
java run
:no
PAUSE
EXIT