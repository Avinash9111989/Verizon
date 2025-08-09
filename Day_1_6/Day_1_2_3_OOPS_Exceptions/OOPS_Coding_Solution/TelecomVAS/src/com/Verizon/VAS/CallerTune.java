package com.Verizon.VAS;

public class CallerTune extends VAS implements Billing {

	@Override
	public int deduct(User u) {
		// TODO Auto-generated method stub

		return u.getBalance() - 100;
	}

	@Override
	void subscribe(User u) {
		// TODO Auto-generated method stub
		System.out.println("Subscription for CallerTune is done for userId " + u.getUserId());
		super.serviceId = 1; // caller tune serviceId=1
		int balance = deduct(u);
		System.out.println("Remaianing balance amount " + balance);
		System.out.print("service Activated " + serviceId);
	}

}
