@SET /P _class=Enter the production class:  edu.oakland.classProject.production.
@SET _path=%_class:.=\%

javac -d bin -sourcepath source source\edu\oakland\classProject\production\%_path%.java

java -cp bin edu.oakland.classProject.production.%_class%

@pause