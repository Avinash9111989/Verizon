package com.verizon.billing;

class PrepaidPlan extends Plan {
	 public double getCallRate() { return 0.5; }
	 public double getSmsRate() { return 0.25; }
	 public double getDataRate() { return 10.0; }
	}

