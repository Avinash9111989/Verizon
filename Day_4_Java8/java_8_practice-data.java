import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamApiPractice {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 10, 20);
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "Arjun", "Deepa");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        List<Employee> employees = Arrays.asList(
                new Employee("Ram", "IT", 50000),
                new Employee("Sam", "HR", 45000),
                new Employee("John", "IT", 60000),
                new Employee("Peter", "Sales", 40000)
        );

        List<User> users = Arrays.asList(
                new User("u1", "active"),
                new User("u2", "inactive"),
                new User("u3", "active")
        );

        List<Product> products = Arrays.asList(
                new Product("Pen", 20, 10),
                new Product("Laptop", 50000, 0),
                new Product("Book", 200, 5)
        );

        List<Student> students = Arrays.asList(
                new Student("Ravi", 85),
                new Student("Sneha", 92),
                new Student("Karan", 88),
                new Student("Megha", 79)
        );

        List<Customer> customers = Arrays.asList(
                new Customer("Amit", "Bangalore", "amit@example.com"),
                new Customer("Raj", "Delhi", "raj@example.com"),
                new Customer("Neha", "Bangalore", "neha@example.com")
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(2500),
                new Transaction(1500),
                new Transaction(3000)
        );

            }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String dept, double salary) {
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String toString() { return name + "(" + department + ":" + salary + ")"; }
}

class User {
    private String userId;
    private String status;

    public User(String id, String status) {
        this.userId = id;
        this.status = status;
    }

    public String getStatus() { return status; }
    public String toString() { return userId + " - " + status; }
}

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public String toString() { return name + ": Rs." + price + " (Stock: " + stock + ")"; }
}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() { return marks; }
    public String toString() { return name + " - " + marks; }
}

class Customer {
    private String name;
    private String city;
    private String email;

    public Customer(String name, String city, String email) {
        this.name = name;
        this.city = city;
        this.email = email;
    }

    public String getCity() { return city; }
    public String getEmail() { return email; }
}

class Transaction {
    private double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() { return amount; }
} 
