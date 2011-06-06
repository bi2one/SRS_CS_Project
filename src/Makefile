FLAGS = -g
JC = javac
TESTDRIVE_PACKAGE = ./
SRS_PACKAGE = ./com/cs/srs/
MODEL_PACKAGE = ${SRS_PACKAGE}model/
MODELDATA_PACKAGE = ${MODEL_PACKAGE}data/

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	${SRS_PACKAGE}Config.java \
	${MODEL_PACKAGE}Model.java \
	${MODEL_PACKAGE}MemberModel.java \
	${MODEL_PACKAGE}ItemModel.java \
	${MODEL_PACKAGE}ReportModel.java \
	${MODEL_PACKAGE}BuyingItemModel.java \
	${MODEL_PACKAGE}BuyingRetailerItemModel.java \
	${MODEL_PACKAGE}BuyingWholesalerItemModel.java \
	${MODEL_PACKAGE}FactoryItemModel.java \
	${MODEL_PACKAGE}WholesalerItemModel.java \
	${MODEL_PACKAGE}RetailerItemModel.java \
	${MODEL_PACKAGE}ConsumerItemModel.java \
	${MODELDATA_PACKAGE}SRSData.java \
	${MODELDATA_PACKAGE}Member.java \
	${MODELDATA_PACKAGE}Item.java \
	${MODELDATA_PACKAGE}Report.java \
	${MODELDATA_PACKAGE}BuyingItem.java \
	${MODELDATA_PACKAGE}BuyingRetailerItem.java \
	${MODELDATA_PACKAGE}BuyingWholesalerItem.java \
	${MODELDATA_PACKAGE}FactoryItem.java \
	${MODELDATA_PACKAGE}WholesalerItem.java \
	${MODELDATA_PACKAGE}RetailerItem.java \
	${MODELDATA_PACKAGE}ConsumerItem.java \
	${TESTDRIVE_PACKAGE}ModelTestDrive.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ${SRS_PACKAGE}*.class
	$(RM) ${MODEL_PACKAGE}*.class
	$(RM) ${MODELDATA_PACKAGE}*.class
	$(RM) ${TESTDRIVE_PACKAGE}*.class
