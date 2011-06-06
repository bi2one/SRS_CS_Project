#!/bin/sh

CLASSPATHN=~/workspace/SRS_CS_Project/src/
# CLASSPATHN=~/workspace/SRS_CS_Project/src/com/cs/srs/modelTestDrive/:$CLASSPATHN
CLASSPATHN=~/workspace/SRS_CS_Project/src/lib/jdbc/mysql-connector-java-5.1.16-bin.jar:$CLASSPATHN

export CLASSPATH=${CLASSPATHN}
