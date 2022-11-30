@ECHO OFF
TITLE FEVERDX SrcBuilder (C) SEGA
ECHO PuyoPop Fever ReChained SourceBuilder (J2ME MIDP 2.0)
ECHO Ver. 1.0
ECHO.
ECHO Created by Realtimeless.
ECHO.
REM # [ Boilerplate J2ME project build script ]
REM # - Nokia64 - v0.1 (17-09-2022)


REM Update these variables to fit your system/project
SET PROJECT_NAME=PuyoFeverReChainedID
SET MAIN_CLASS="puyo/Puyo"
SET JDKPATH="C:\Program Files\Java\(JDK Main Directory)"
SET PROGUARD="(ProGuard JAR File)"
SET ADVZIP=""
SET CLASS_VERSION="1.4"

IF /I [%1]==[CLEAN] GOTO CLEAN

REM Find all libraries/*.jar files and build the classpath variable
SET CLASSPATH=
SET CLASSCOUNT=0
FOR %%J in (libraries\*.jar) DO CALL :ADD_CLASS %%J
GOTO :ADD_CLASS_END
:ADD_CLASS
  IF NOT %CLASSCOUNT%==0 SET CLASSPATH=%CLASSPATH%;
  SET CLASSPATH=%CLASSPATH%%1
  SET /A CLASSCOUNT=%CLASSCOUNT% + 1
  EXIT /B
:ADD_CLASS_END

REM Make sure the necessary output directories exist
MKDIR out\classes 2> NUL

REM Compile the sources
ECHO - COMPILE CLASSES...
ECHO Compiling Java source file into a compiled class file...
ECHO.
%JDKPATH%\bin\javac.exe -source %CLASS_VERSION% -target %CLASS_VERSION% -cp %CLASSPATH% -encoding utf-8 -d out/classes -sourcepath source -Xlint:-options -g:none source/%MAIN_CLASS%.java
IF NOT %ERRORLEVEL% == 0 GOTO ERROR

REM Build the JAR file
ECHO - BUILD MIDLET...
ECHO Building MIDlet...
ECHO.
%JDKPATH%\bin\jar.exe cvfm out\%PROJECT_NAME%_not_preverified.jar source\META-INF\MANIFEST.MF -C out\classes . -C assets .
IF NOT %ERRORLEVEL% == 0 GOTO ERROR

REM Preverify with Proguard
ECHO - PREVERIFY MIDLET...
ECHO Preverifying MIDlet...
ECHO.
%JDKPATH%\bin\java.exe -jar %PROGUARD% -microedition -injars out\%PROJECT_NAME%_not_preverified.jar -outjars out\%PROJECT_NAME%.jar -libraryjars %CLASSPATH% -dontshrink -dontoptimize -dontobfuscate -target %CLASS_VERSION%
IF NOT %ERRORLEVEL% == 0 GOTO ERROR
DEL out\%PROJECT_NAME%_not_preverified.jar

REM Make a release build
IF /I NOT [%1]==[RELEASE] GOTO NO_RELEASE
ECHO - BUILD RELEASE MIDLET...
ECHO Building Release MIDlet...
ECHO.
REM %JDKPATH%\bin\java.exe -jar %PROGUARD% -microedition -injars out\%PROJECT_NAME%.jar -outjars out\%PROJECT_NAME%_release.jar -libraryjars %CLASSPATH% -target %CLASS_VERSION% -keep "class * extends javax.microedition.midlet.MIDlet" -optimizationpasses 4 -overloadaggressively -repackageclasses "" -allowaccessmodification
%JDKPATH%\bin\java.exe -jar %PROGUARD% -microedition -injars out\%PROJECT_NAME%.jar -outjars out\%PROJECT_NAME%_release.jar -libraryjars %CLASSPATH% -target %CLASS_VERSION% -dontobfuscate -keep "class * extends javax.microedition.midlet.MIDlet" -optimizationpasses 4 -repackageclasses "" -allowaccessmodification

IF NOT %ERRORLEVEL% == 0 GOTO ERROR

REM Release build: Optimize JAR filesize (if advzip is present)
IF [%ADVZIP%]==[] GOTO NO_ADVZIP
ECHO - OPTIMIZE RELEASE MIDLET...
ECHO Optimizing Release MIDlet...
ECHO.
%ADVZIP% -z -3 out\%PROJECT_NAME%_release.jar
IF NOT %ERRORLEVEL% == 0 GOTO ERROR
:NO_ADVZIP
:NO_RELEASE

ECHO.
ECHO - BUILD COMPLETE!
ECHO Building J2ME project has been completed
ECHO with no errors.
ECHO.
PAUSE
EXIT /B 0

:ERROR
ECHO - BUILD ERROR!
ECHO An error occured while building this project.
ECHO.
ECHO To make sure that there is no errors in a
ECHO Java source file, then you can rebuild.
ECHO.
PAUSE
EXIT /B 1

:CLEAN
RMDIR /Q /S out\ 2> NUL
EXIT /B 0