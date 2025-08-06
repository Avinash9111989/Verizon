
package com.telecombilling;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TelecomBillingSystemTest {
    private TelecomBillingSystem billingSystem;

    @BeforeEach
    public void setUp() {
        billingSystem = new TelecomBillingSystem();
        Customer customer = new Customer("CUST001", "Alice Smith", "alice@example.com", "postpaid");
        billingSystem.addCustomer(customer);
    }

    @Test
    public void testGenerateInvoiceSuccess() {
        assertDoesNotThrow(() -> {
            Invoice invoice = billingSystem.generateInvoice("CUST001", 100.0, 50.0, 10.0);
            assertNotNull(invoice);
            assertEquals("CUST001", invoice.getCustomerId());
            assertEquals(160.0, invoice.getAmount(), 0.01);
        });
    }

    @Test
    public void testGenerateInvoiceInvalidCustomer() {
        BillingException thrown = assertThrows(BillingException.class, () -> {
            billingSystem.generateInvoice("INVALID_ID", 10.0, 10.0, 10.0);
        });
        assertEquals("Customer not found.", thrown.getMessage());
    }

    @Test
    public void testGenerateInvoiceNegativeAmount() {
        BillingException thrown = assertThrows(BillingException.class, () -> {
            billingSystem.generateInvoice("CUST001", -10.0, -20.0, -5.0);
        });
        assertEquals("Calculated bill cannot be negative.", thrown.getMessage());
    }

    @AfterEach
    public void tearDown() {
        billingSystem = null;
    }
}
