@echo off 

set DATABASE_DIR=D:\SCRE\git\stundenabrechnung\db\stundenabrechnung
set JBOSS_BIN_DIR=D:\SCRE_Library\jboss-as-7.1.1.Final\bin
set JBOSS_PORT_OFFSET=1

echo Sarting Database
start /b java -cp D:\SCRE_Library\hsqldb\lib\hsqldb.jar org.hsqldb.Server -database.0 file:%DATABASE_DIR% -dbname.0 stundenabrechnung

sleep 3

echo Starting JBoss
rem %JBOSS_BIN_DIR%\standalone.bat -Djboss.socket.binding.port-offset=%JBOSS_PORT_OFFSET%