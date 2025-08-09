package com.verizon.billing;

import java.util.*;


//Main Billing System
public class TelBilling {
 static Map<String, Customer> customers = new HashMap<>();
 static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
     while (true) {
         System.out.println("\n--- TELECOM BILLING SYSTEM ---");
         System.out.println("1. Add Customer");
         System.out.println("2. Generate Bill");
         System.out.println("3. Exit");
         System.out.print("Enter choice: ");
         int choice = sc.nextInt();

         switch (choice) {
             case 1: addCustomer(); break;
             case 2: generateBill(); break;
             case 3: System.exit(0);
             default: System.out.println("Invalid choice.");
         }
     }
 }

 static void addCustomer() {
     System.out.print("Enter Name: ");
     sc.nextLine(); // consume newline
     String name = sc.nextLine();
     System.out.print("Enter Mobile Number: ");
     String mobile = sc.nextLine();
     System.out.print("Enter Plan Type (Prepaid/Postpaid): ");
     String type = sc.nextLine();

     Plan plan;
     if (type.equalsIgnoreCase("prepaid")) {
         plan = new PrepaidPlan();
     } else if (type.equalsIgnoreCase("postpaid")) {
         plan = new PostpaidPlan();
     } else {
         System.out.println("Invalid plan type!");
         return;
     }

     customers.put(mobile, new Customer(name, mobile, plan));
     System.out.println("Customer added successfully.");
 }

 static void generateBill() {
     try {
         System.out.print("Enter Mobile Number: ");
         sc.nextLine(); // consume newline
         String mobile = sc.nextLine();

         if (!customers.containsKey(mobile)) {
             throw new CustomerNotFoundException("Customer not found!");
         }

         System.out.print("Enter No. of Calls: ");
         int calls = sc.nextInt();
         System.out.print("Enter No. of SMS: ");
         int sms = sc.nextInt();
         System.out.print("Enter Data Used (in GB): ");
         double data = sc.nextDouble();

         if (calls < 0 || sms < 0 || data < 0) {
             throw new InvalidUsageException("Usage values cannot be negative.");
         }

         Customer c = customers.get(mobile);
         Plan p = c.getPlan();

         double bill = (calls * p.getCallRate()) + (sms * p.getSmsRate()) + (data * p.getDataRate());

         System.out.println("\n--- BILL DETAILS ---");
         System.out.println("Customer: " + c.getName());
         System.out.println("Plan Type: " + (p instanceof PrepaidPlan ? "Prepaid" : "Postpaid"));
         System.out.println("Calls: " + calls + " x ₹" + p.getCallRate());
         System.out.println("SMS: " + sms + " x ₹" + p.getSmsRate());
         System.out.println("Data: " + data + " GB x ₹" + p.getDataRate());
         System.out.printf("Total Bill: ₹%.2f\n", bill);

     } catch (InputMismatchException e) {
         System.out.println("Invalid input type. Please enter numeric values.");
         sc.nextLine(); // clear the buffer
     } catch (InvalidUsageException | CustomerNotFoundException e) {
         System.out.println(e.getMessage());
     }
 }
}


