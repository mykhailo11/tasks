set PRJ=%cd%
cd src
javac -cp ".;%PRJ%/lib/junit-4.13.2.jar;%PRJ%/lib/hamcrest-core-1.3.jar" -d "%PRJ%/bin" main/*.java
javac -cp ".;%PRJ%/lib/junit-4.13.2.jar;%PRJ%/lib/hamcrest-core-1.3.jar" -d "%PRJ%/bin" test/*.java
cmd /k