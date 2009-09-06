package com.ambientideas;

import java.util.LinkedList;
import java.util.List;

public class QueryHistory {
    public static List queryHistory = new LinkedList();
    
    public static void addHistoryElement(String history) {
        queryHistory.add(new StringBuffer(5000000).append(history));
        System.out.println("Query History List Size: " + queryHistory.size());
    }
}