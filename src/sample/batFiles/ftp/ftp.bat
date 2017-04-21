@ECHO OFF
ECHO ------------------------------------
ECHO 	 SSH - Components App
ECHO ------------------------------------
ECHO 	BY PRANAV and KEDAR
ECHO -------------------------------------
ECHO    Now Control will be given to PuTTY
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