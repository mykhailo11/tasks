set PRJ=%cd%
cd bin
java -cp ".;%PRJ%/lib/junit-4.13.2.jar;%PRJ%/lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.TasksTest
cmd /k