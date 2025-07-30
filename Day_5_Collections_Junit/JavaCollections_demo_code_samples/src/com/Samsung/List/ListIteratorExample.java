package com.Samsung.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample{  
public static void main(String args[]){  
List<String> al=new ArrayList<String>();    
        al.add("Amit");    
        al.add("Vijay");    
        al.add("Kumar");    
        al.add(1,"Sachin");    
        ListIterator<String> itr=al.listIterator();    
        System.out.println("Traversing elements in forward direction");    
        while(itr.hasNext()){    
              
        System.out.println("index:"+itr.nextIndex()+" value:"+itr.next());    
        }    
        System.out.println("Traversing elements in backward direction");    
        while(itr.hasPrevious()){    
          
        System.out.println("index:"+itr.previousIndex()+" value:"+itr.previous());    
        }    
}  
}  