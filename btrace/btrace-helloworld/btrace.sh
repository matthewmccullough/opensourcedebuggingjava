set +x
APPPID=$1
btrace $APPPID TraceAllMethodCalls.java&
