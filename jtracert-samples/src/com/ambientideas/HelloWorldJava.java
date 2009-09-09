package com.ambientideas;

import com.ambientideas.Logic;

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
    System.out.println("Hello Java World!");
    new Logic().doSomething();
    new java.util.ArrayList(1000);
    Thread.sleep(3000);
  }
}