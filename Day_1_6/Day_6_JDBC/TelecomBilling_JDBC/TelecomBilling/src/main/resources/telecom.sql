CREATE TABLE customers (
  customer_id VARCHAR(20) PRIMARY KEY,
  name VARCHAR(100),
  contact VARCHAR(100),
  plan_type VARCHAR(20)
);

CREATE TABLE invoices (
  invoice_id VARCHAR(36) PRIMARY KEY,
  customer_id VARCHAR(20),
  amount DOUBLE,
  billing_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
