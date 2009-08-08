set +x
javac HelloWorldJava.java
rm com/ambientideas/HelloWorldJava.class
mv HelloWorldJava.class com/ambientideas/
java com.ambientideas.HelloWorldJava&
APPPID=$!
echo ***** Java app running with PID: $APPPID
btrace $APPPID TraceAllMethodCalls.java&
read -t 20 -n 1 -p 'Press any key to quit ->' MYVAR
kill $APPPID