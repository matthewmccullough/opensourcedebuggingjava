package com.ambientideas.btrace.samples;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Intercept and report all calls to log() on our ActionTracker
 */
@BTrace public class TraceJackedUpAppLog {
    //@OnMethod(clazz="/.*HashMap.*/", method="/.*put.*/")
	@OnMethod(clazz="/.*/", method="/.*log.*/")
    public static void m(Object self, String method) {
        println(strcat("!!! Btrace discovered that log was called on ActionTracker: ", method));
    }
   
    private static Map<String, AtomicInteger> histo = newHashMap();

    @OnMethod(clazz="/.*String.*/", method="<init>") 
    public static void onnewObject(Object obj) {
        String cn = name(classOf(obj));
        AtomicInteger ai = get(histo, cn);
        if (ai == null) {
            ai = newAtomicInteger(1);
            put(histo, cn, ai);
        } else {
            incrementAndGet(ai);
        }     
    }
    
    @OnEvent
    public static void print() {
        if (size(histo) != 0) {
            printNumberMap("Component Histogram", histo);
        }
    }
}