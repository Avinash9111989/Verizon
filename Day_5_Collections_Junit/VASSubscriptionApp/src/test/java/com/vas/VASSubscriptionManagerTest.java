package com.vas;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class VASSubscriptionManagerTest {

    User user;
    VASSubscriptionManager manager;

    @BeforeEach
    void setUp() {
        user = new User("U1", "John", "9999999999", 200);
        manager = new VASSubscriptionManager();
    }

    @Test
    void testCallerTuneSubscription() {
        manager.subscribe(user, new CallerTune());
        assertEquals(100, user.getBalance());
        assertTrue(manager.getSubscribedServices(user).contains("Caller Tune"));
    }

    @Test
    void testDuplicateSubscriptionThrowsException() {
        manager.subscribe(user, new DND());
        Exception e = assertThrows(RuntimeException.class, () -> manager.subscribe(user, new DND()));
        assertEquals("Already subscribed to: DND", e.getMessage());
    }

    @Test
    void testUnsubscribeVAS() {
        manager.subscribe(user, new DND());
        manager.unsubscribe(user, "DND");
        assertFalse(manager.getSubscribedServices(user).contains("DND"));
    }

    @Nested
    class BalanceRelatedTests {
        @Test
        void testBalanceAfterCallerTune() {
            manager.subscribe(user, new CallerTune());
            assertEquals(100, user.getBalance());
        }

        @Test
        void testInsufficientBalance() {
            user.setBalance(50);
            Exception e = assertThrows(RuntimeException.class, () -> manager.subscribe(user, new CallerTune()));
            assertEquals("Insufficient balance", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"DND", "Caller Tune"})
    void testValidSubscriptions(String service) {
        VAS vas = service.equals("DND") ? new DND() : new CallerTune();
        manager.subscribe(user, vas);
        assertTrue(manager.getSubscribedServices(user).contains(service));
    }
}
