FLAGS = -g
JC = javac
TESTDRIVE_PACKAGE = src/
SRS_PACKAGE = src/com/cs/srs/
MODEL_PACKAGE = ${SRS_PACKAGE}model/

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	${SRS_PACKAGE}Config.java \
	${MODEL_PACKAGE}Model.java \
	${TESTDRIVE_PACKAGE}ModelTestDrive.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class