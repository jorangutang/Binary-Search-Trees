JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	javac *.java

CLASSES = \
	src\*.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) src\*.class

run:
	$(java) src\java PowerArrayApp