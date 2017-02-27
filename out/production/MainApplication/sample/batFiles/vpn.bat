@echo off
title VPN
echo VPN
echo Copying Files
copy D:\PRANAV\Project\MainApplication\src\sample\vpnData\CanadaVPNConnection\rasphone.pbk C:\Windows\System32\rasphone.pbk
pause
echo Starting VPN
rasdial "Canada VPN Connection" justfreevpn 9915
pause
exit