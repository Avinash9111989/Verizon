package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    Calculator calc;

    @BeforeAll
    void initAll() {
        System.out.println(">> Before All Tests");
    }

    @BeforeEach
    void init() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("-> Test finished");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println(">> After All Tests");
    }

    @Test
    @DisplayName("Addition Test")
    @Tag("math")
    @Order(1)
    void testAddition() {
        assertEquals(5, calc.add(2, 3), "Addition failed");
    }

    @Test
    @DisplayName("Subtraction Test")
    @Tag("math")
    @Order(2)
    void testSubtraction() {
        assertNotEquals(5, calc.subtract(3, 2));
    }

    @Test
    @DisplayName("Multiplication Test")
    @Tag("math")
    @Order(3)
    void testMultiplication() {
        assertTrue(calc.multiply(2, 3) == 6);
        assertFalse(calc.multiply(2, 2) == 6);
    }

    @Test
    @DisplayName("Null and NotNull Test")
    @Order(4)
    void testNullCheck() {
        String a = null;
        String b = "JUnit";
        assertNull(a);
        assertNotNull(b);
    }

    @Test
    @DisplayName("Same and NotSame Test")
    @Order(5)
    void testSameCheck() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        assertSame(a, b);
        assertNotSame(a, c);
    }

    @Test
    @DisplayName("Array Equals Test")
    @Order(6)
    void testArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Iterable Equals Test")
    @Order(7)
    void testIterableEquals() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3);
        assertIterableEquals(list1, list2);
    }

    @Test
    @DisplayName("Exception Test")
    @Order(8)
    void testException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    @ParameterizedTest
    @CsvSource({"4, 2, 2", "9, 3, 3", "10, 2, 5"})
    @Order(9)
    void testDivision(int a, int b, int expected) {
        assertEquals(expected, calc.divide(a, b));
    }

    @Test
    @Order(10)
    @EnabledOnOs(OS.WINDOWS)
    void testOnlyOnWindows() {
        System.out.println("This runs only on Windows");
    }

    @Test
    @Order(11)
    @DisabledOnOs(OS.LINUX)
    void testDisabledOnLinux() {
        System.out.println("This will not run on Linux");
    }

    @Test
    @Order(12)
    @EnabledIfSystemProperty(named = "env", matches = "test")
    void testEnabledIfSystemProperty() {
        System.out.println("System property matched");
    }

    @Test
    @Order(13)
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void testEnabledIfEnvVar() {
        System.out.println("Environment variable matched");
    }

    @Test
    @Order(14)
    @DisabledIfEnvironmentVariable(named = "ENV", matches = "PROD")
    void testDisabledIfEnvVar() {
        System.out.println("Will not run on PROD");
    }

    @Test
    @Order(15)
    void testAssumption() {
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"));
        assertEquals(4, calc.add(2, 2));
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NestedAddTests {
        @Test
        @Order(1)
        void testPositiveAdd() {
            assertEquals(7, calc.add(3, 4));
        }

        @Test
        @Order(2)
        void testNegativeAdd() {
            assertEquals(-1, calc.add(-2, 1));
        }
    }
}
