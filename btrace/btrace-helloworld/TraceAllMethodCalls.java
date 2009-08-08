import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.AnyType;
import java.lang.management.MemoryUsage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@BTrace public class TraceAllMethodCalls {
  /**
   * METHOD CALL TRACEPOINT.
   */
    @OnMethod(
        clazz="com.ambientideas.HelloWorldJava",
        method="print",
        location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/")
    )
    public static void m(AnyType[] args) {
        println(strcat("****** WE'VE ENTERED A METHOD ON CLASS: ", name(probeClass())));
        println(strcat("****** WE'VE ENTERED METHOD: ", probeMethod()));
    }
    
    @OnMethod(
        clazz="/.*/",
        method="println"
    )
    public static void m2(AnyType[] args) {
        println(strcat("****** WE'VE ENTERED A METHOD ON CLASS: ", name(probeClass())));
        println(strcat("****** WE'VE ENTERED METHOD: ", probeMethod()));
    }
    
    
    
    /**
     * ONEXIT TRACEPOINT. CALLED WHEN A BTRACE METHOD CALLS EXIT(INT).
     */
    @OnExit
    public static void onexit(int code) {
        println("****** THE BTRACE PROGRAM IS EXITING.");
    }

    /**
     * LOW MEMORY TRACE POINT.
     */
    @OnLowMemory(
        pool = "Tenured Gen",
        threshold=58720250     
    )
    public static void onLowMem(MemoryUsage mu) {
        println("******");
        println(mu); 
    }
    
    
    /**
     * MEMORY HISTOGRAM TRACE POINT.
     */
    private static Map<String, AtomicInteger> histo = newHashMap();

    @OnTimer(4000)
    public static void print() {
        if (size(histo) != 0) {
            printNumberMap(strcat("******", "Component Histogram"), histo);
        }
    }
}
