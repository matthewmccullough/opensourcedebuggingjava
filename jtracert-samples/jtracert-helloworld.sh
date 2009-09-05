#JTracert location
export JTRACERT_HOME=/Applications/Dev/jtracert
#GOING TO USE JUST A HELLOWORLD FOR NOW export JAVA2D_HOME=/Developer/Examples/Java/JFC/Java2D

#Run java2d with jtracert listener
#java -jar $JAVA2D_HOME/Java2D.jar -javaagent:$JTRACERT_HOME/jTracert.jar=7007 &
#java -javaagent:$JTRACERT_HOME/jTracert.jar -DclassNameRegEx=.* -DverboseInstrumentation -DverboseAnalyze -DanalyzerOutput=webSequenceDiagramsOut -DoutputFolder=/Users/mccm06/Documents/Teach/Courses/Open-Source-Debugging-CombinedTools-NFJS/example-files_git/jtracert-samples com.ambientideas.HelloWorldJava
java -javaagent:$JTRACERT_HOME/jTracert.jar=7007 -DclassNameRegEx=.* -DverboseInstrumentation -DverboseAnalyze com.ambientideas.HelloWorldJava &
APPPID=$!

cd $JTRACERT_HOME
jtracert.sh

kill $APPPID