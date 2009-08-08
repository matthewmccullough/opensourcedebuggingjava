package com.ambientideas;

/**
 * Hello world!
 *
 */
public class App implements java.io.Serializable
{
    public static void main( String[] args )
    {
      System.out.println( "Hello World!" );
    }
    
    private static void doSomethingInternal() {
      System.out.println( "Internals!" );
    }
    
    //Bean properties
    String name;
    Integer age;
    
    //Private properties
    private String spouseName;
}
