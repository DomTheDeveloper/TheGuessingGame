@SET _class=Main
@SET _path=%_class:.=\%

javac -d bin -sourcepath source source\edu\oakland\classProject\production\%_path%.java

java -cp bin edu.oakland.classProject.production.%_class%

@pause