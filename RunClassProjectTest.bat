@SET /P _class=Enter the  test class:  edu.oakland.classProject.test.
@SET _path=%_class:.=\%

javac -d bin -sourcepath source -cp c:\junit3.8.2\junit.jar source\edu\oakland\classProject\test\%_path%.java

java -cp bin;c:\junit3.8.2\junit.jar junit.swingui.TestRunner edu.oakland.classProject.test.%_class%

@pause