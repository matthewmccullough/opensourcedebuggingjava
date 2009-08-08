package com.ambientideas;

public class HelloWorldJava {
  public static void main(String[] args) throws Exception {
    new HelloWorldJava().run();
  }
  
  public void run() throws Exception {
    while (true) {
      print();
    }
  }
  
  public void print() throws Exception {
    String helloWorld = "Hello Java World!";
    System.out.println(helloWorld);
    new java.util.ArrayList(1000);
    Thread.sleep(1000);
  }
}