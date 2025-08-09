package com.Verizon.VAS;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       User u=new User();
       u.setUserId(1);
       u.setName("Avi");
       u.setBalance(10000);
       VAS v= new CallerTune();
       v.subscribe(u);
	}

}
