package com.Samsung.List;

import java.util.*;  
public class ArrayToList{  
public static void main(String args[]){  
//Creating Array  
String[] array={"Java","Python","PHP","C++"};  
System.out.println("Printing Array: "+Arrays.toString(array));  
//Converting Array to List  
List<String> list=new ArrayList<String>();  
for(String lang:array){  
list.add(lang);  
}  
System.out.println("Printing List: "+list);  
  
}  
}  