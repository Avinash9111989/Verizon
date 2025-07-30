package com.verizon.billing;

class Customer {
	 private String name;
	 private String mobile;
	 private Plan plan;

	 public Customer(String name, String mobile, Plan plan) {
	     this.name = name;
	     this.mobile = mobile;
	     this.plan = plan;
	 }

	 public String getName() { return name; }
	 public String getMobile() { return mobile; }
	 public Plan getPlan() { return plan; }
	}
