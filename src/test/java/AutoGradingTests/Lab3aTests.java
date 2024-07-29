package AutoGradingTests;


import org.junit.jupiter.api.Test;

import DessertShop.Candy;
import DessertShop.Cookie;
import DessertShop.DessertItem;
import DessertShop.IceCream;
import DessertShop.Sundae;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

public class Lab3aTests {
    // INHERITANCE TEST //
    @Test
    public void testInheritance() {
        assertEquals(DessertItem.class, Candy.class.getSuperclass());
        assertEquals(DessertItem.class, Cookie.class.getSuperclass());
        assertEquals(DessertItem.class, IceCream.class.getSuperclass());
        assertEquals(IceCream.class, Sundae.class.getSuperclass());
    }

    // DESSERT ITEM TESTS //
    @Test
    public void testDessertItemAttributes() {
        assertDoesNotThrow(() -> {
            Field nameField = DessertItem.class.getDeclaredField("name");
            assertEquals(String.class, nameField.getType(), "The attribute `name` should be of type String");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `name` attribute should be private");
        }, "DessertItem should have a private String attribute called name");
    }

    @Test
    public void testDessertItemConstructors() {
        assertDoesNotThrow(() -> {
            Constructor<DessertItem> defaultConstructor = DessertItem.class.getDeclaredConstructor();
            assertNotNull(defaultConstructor, "DessertItem should have a default constructor");
        });
        assertDoesNotThrow(() -> {
            Constructor<DessertItem> stringConstructor = DessertItem.class.getDeclaredConstructor(String.class);
            assertNotNull(stringConstructor, "DessertItem should have a constructor that takes a String as a parameter");
        });
    }

    @Test
    public void testDessertItemMethods() throws NoSuchMethodException {
        Method getMethod = DessertItem.class.getDeclaredMethod("getName");
        assertEquals(String.class, getMethod.getReturnType(), "getName should return String");
        Method setMethod = DessertItem.class.getDeclaredMethod("setName", String.class);
        assertNotNull(setMethod, "DessertItem should have a method called `setName` that takes a String as an argument");
    }


    // CANDY TESTS //
    @Test
    public void testCandyAttributes() {
        assertDoesNotThrow(() -> {
            Field nameField = Candy.class.getDeclaredField("candyWeight");
            assertEquals(double.class, nameField.getType(), "The attribute `candyWeight` should be of type double");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `candyWeight` attribute should be private");
        }, "Candy should have a private double attribute called candyWeight");
        assertDoesNotThrow(() -> {
            Field nameField = Candy.class.getDeclaredField("pricePerPound");
            assertEquals(double.class, nameField.getType(), "The attribute `pricePerPound` should be of type double");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `pricePerPound` attribute should be private");
        }, "Candy should have a private double attribute called pricePerPound");
    }

    @Test
    public void testCandyConstructors() {
        assertDoesNotThrow(() -> {
            Constructor<Candy> defaultConstructor = Candy.class.getDeclaredConstructor();
            assertNotNull(defaultConstructor, "Candy should have a default constructor");
        });
        assertDoesNotThrow(() -> {
            Constructor<Candy> stringConstructor = Candy.class.getDeclaredConstructor(String.class, double.class, double.class);
            assertNotNull(stringConstructor, "Candy should have a constructor that takes a String, double, and double as parameters");
        });
    }

    @Test
    public void testCandyMethods() throws NoSuchMethodException {
        Method getMethod = Candy.class.getDeclaredMethod("getCandyWeight");
        assertEquals(double.class, getMethod.getReturnType(), "getCandyWeight should return double");
        Method setMethod = Candy.class.getDeclaredMethod("setCandyWeight", double.class);
        assertNotNull(setMethod, "Candy should have a method called `setCandyWeight` that takes a double as an argument");
        Method getMethod2 = Candy.class.getDeclaredMethod("getPricePerPound");
        assertEquals(double.class, getMethod2.getReturnType(), "getPricePerPound should return double");
        Method setMethod2 = Candy.class.getDeclaredMethod("setPricePerPound", double.class);
        assertNotNull(setMethod2, "Candy should have a method called `setPricePerPound` that takes a double as an argument");
    }


    // COOKIES TESTS //
    // attributes: private int cookieQty, private double pricePerDozen
    @Test
    public void testCookieAttributes() {
        assertDoesNotThrow(() -> {
            Field nameField = Cookie.class.getDeclaredField("cookieQty");
            assertEquals(int.class, nameField.getType(), "The attribute `cookieQty` should be of type int");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `cookieQty` attribute should be private");
        }, "Cookie should have a private int attribute called cookieQty");
        assertDoesNotThrow(() -> {
            Field nameField = Cookie.class.getDeclaredField("pricePerDozen");
            assertEquals(double.class, nameField.getType(), "The attribute `pricePerDozen` should be of type double");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `pricePerDozen` attribute should be private");
        }, "Cookie should have a private double attribute called pricePerDozen");
    }

    //2 constructors
    @Test
    public void testCookieConstructors() {
        assertDoesNotThrow(() -> {
            Constructor<Cookie> defaultConstructor = Cookie.class.getDeclaredConstructor();
            assertNotNull(defaultConstructor, "Cookie should have a default constructor");
        });
        assertDoesNotThrow(() -> {
            Constructor<Cookie> stringConstructor = Cookie.class.getDeclaredConstructor(String.class, int.class, double.class);
            assertNotNull(stringConstructor, "Cookie should have a constructor that takes a String, int, and double as parameters");
        });
    }

    //methods: getCookieQty, setCookieQty, getPricePerDozen, setPricePerDozen
    @Test
    public void testCookieMethods() throws NoSuchMethodException {
        Method getMethod = Cookie.class.getDeclaredMethod("getCookieQty");
        assertEquals(int.class, getMethod.getReturnType(), "getCookieQty should return int");
        Method setMethod = Cookie.class.getDeclaredMethod("setCookieQty", int.class);
        assertNotNull(setMethod, "Cookie should have a method called `setCookieQty` that takes an int as an argument");
        Method getMethod2 = Cookie.class.getDeclaredMethod("getPricePerDozen");
        assertEquals(double.class, getMethod2.getReturnType(), "getPricePerDozen should return double");
        Method setMethod2 = Cookie.class.getDeclaredMethod("setPricePerDozen", double.class);
        assertNotNull(setMethod2,"Cookie should have a method called `setPricePerDozen` that takes a double as an argument");
    }


    // ICE CREAM TESTS //
    // attributes: private int scoopCount, private double pricePerScoop
    @Test
    public void testIceCreamAttributes() {
        assertDoesNotThrow(() -> {
            Field nameField = IceCream.class.getDeclaredField("scoopCount");
            assertEquals(int.class, nameField.getType(), "The attribute `scoopCount` should be of type int");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `scoopCount` attribute should be private");
        }, "IceCream should have a private int attribute called scoopCount");
        assertDoesNotThrow(() -> {
            Field nameField = IceCream.class.getDeclaredField("pricePerScoop");
            assertEquals(double.class, nameField.getType(), "The attribute `pricePerScoop` should be of type double");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `pricePerScoop` attribute should be private");
        }, "IceCream should have a private double attribute called pricePerScoop");
    }

    //2 constructors
    @Test
    public void testIceCreamConstructors() {
        assertDoesNotThrow(() -> {
            Constructor<IceCream> defaultConstructor = IceCream.class.getDeclaredConstructor();
            assertNotNull(defaultConstructor, "IceCream should have a default constructor");
        });
        assertDoesNotThrow(() -> {
            Constructor<IceCream> stringConstructor = IceCream.class.getDeclaredConstructor(String.class, int.class, double.class);
            assertNotNull(stringConstructor, "IceCream should have a constructor that takes a String, int, and double as parameters");
        });
    }

    //methods: getIceCreamQty, setIceCreamQty, getPricePerScoop, setPricePerScoop
    @Test
    public void testIceCreamMethods() throws NoSuchMethodException {
        Method getMethod = IceCream.class.getDeclaredMethod("getScoopCount");
        assertEquals(int.class, getMethod.getReturnType(), "getIceCreamQty should return int");
        Method setMethod = IceCream.class.getDeclaredMethod("setScoopCount", int.class);
        assertNotNull(setMethod, "IceCream should have a method called `setScoopCount` that takes an int as an argument");
        Method getMethod2 = IceCream.class.getDeclaredMethod("getPricePerScoop");
        assertEquals(double.class, getMethod2.getReturnType(), "getPricePerScoop should return double");
        Method setMethod2 = IceCream.class.getDeclaredMethod("setPricePerScoop", double.class);
        assertNotNull(setMethod2, "IceCream should have a method called `setPricePerScoop` that takes a double as an argument");
    }


    // SUNDAE TESTS //
    // attributes: private String toppingName, private double toppingPrice
    @Test
    public void testSundaeAttributes() {
        assertDoesNotThrow(() -> {
            Field nameField = Sundae.class.getDeclaredField("toppingName");
            assertEquals(String.class, nameField.getType(), "The attribute `toppingName` should be of type String");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `toppingName` attribute should be private");
        }, "Sundae should have a private String attribute called toppingName");
        assertDoesNotThrow(() -> {
            Field nameField = Sundae.class.getDeclaredField("toppingPrice");
            assertEquals(double.class, nameField.getType(), "The attribute `toppingPrice` should be of type double");
            assertTrue(java.lang.reflect.Modifier.isPrivate(nameField.getModifiers()), "The `toppingPrice` attribute should be private");
        }, "Sundae should have a private double attribute called toppingPrice");
    }

    //2 constructors
    @Test
    public void testSundaeConstructors() {
        assertDoesNotThrow(() -> {
            Constructor<Sundae> defaultConstructor = Sundae.class.getDeclaredConstructor();
            assertNotNull(defaultConstructor, "Sundae should have a default constructor");
        });
        assertDoesNotThrow(() -> {
            Constructor<Sundae> stringConstructor = Sundae.class.getDeclaredConstructor(String.class, int.class, double.class, String.class, double.class);
            assertNotNull(stringConstructor, "Sundae should have a constructor that takes a String, int, double, String, and double as parameters");
        });
    }

    //methods: getToppingName, setToppingName, getToppingPrice, setToppingPrice
    @Test
    public void testSundaeMethods() throws NoSuchMethodException {
        Method getMethod = Sundae.class.getDeclaredMethod("getToppingName");
        assertEquals(String.class, getMethod.getReturnType(), "getToppingName should return String");
        Method setMethod = Sundae.class.getDeclaredMethod("setToppingName", String.class);
        assertNotNull(setMethod, "Sundae should have a method called `setToppingName` that takes a String as an argument");
        Method getMethod2 = Sundae.class.getDeclaredMethod("getToppingPrice");
        assertEquals(double.class, getMethod2.getReturnType(), "getToppingPrice should return double");
        Method setMethod2 = Sundae.class.getDeclaredMethod("setToppingPrice", double.class);
        assertNotNull(setMethod2, "Sundae should have a method called `setToppingPrice` that takes a double as an argument");
    }

}// end of the lab
