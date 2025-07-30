package com.Samsung.Map;

import java.util.*;  
class LinkedHashMap2{  
 public static void main(String args[]){  
   LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();           
      map.put(102,"Amit");    
     map.put(100,"Vijay");    
     map.put(101,"Rahul");    
       //Fetching key  
       System.out.println("Keys: "+map.keySet());  
       //Fetching value  
       System.out.println("Values: "+map.values());  
       //Fetching key-value pair  
       System.out.println("Key-Value pairs: "+map.entrySet());  
 }  
}  