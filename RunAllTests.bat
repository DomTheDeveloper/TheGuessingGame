
javac -d bin -sourcepath src -cp c:\junit3.8.2\junit.jar src\edu\oakland\classProject\test\CoreTest.java
java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.CoreTest

javac -d bin -sourcepath src -cp c:\junit3.8.2\junit.jar src\edu\oakland\classProject\test\MainTest.java
java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.MainTest

javac -d bin -sourcepath src -cp c:\junit3.8.2\junit.jar src\edu\oakland\classProject\test\DisplayHelperTest.java
java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.DisplayHelperTest

javac -d bin -sourcepath src -cp c:\junit3.8.2\junit.jar src\edu\oakland\classProject\test\EndToEndTest.java
java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.EndToEndTest

javac -d bin -sourcepath src -cp c:\junit3.8.2\junit.jar src\edu\oakland\classProject\test\AutomatedTest.java
java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.AutomatedTest

