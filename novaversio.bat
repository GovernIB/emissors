
@echo off 

IF "%~1" == "" GOTO SENSEPARAMS

@echo on
cmd /C mvn -DgroupId=es.caib.scsp -DartifactId=* versions:set -DnewVersion=%*

@echo off
SETLOCAL EnableDelayedExpansion
for /F "tokens=1,2 delims=#" %%a in ('"prompt #$H#$E# & echo on & for %%b in (1) do rem"') do (
  set "DEL=%%a"
)

@echo. 
@echo.
@echo off

GOTO EXIT

:ColorText
@echo off
<nul set /p ".=%DEL%" > "%~2"
findstr /v /a:%1 /R "^$" "%~2" nul
del "%~2" > nul 2>&1
goto :eof


:SENSEPARAMS

@echo.
@echo.
echo Falta versio
@echo.
@echo.


:EXIT
