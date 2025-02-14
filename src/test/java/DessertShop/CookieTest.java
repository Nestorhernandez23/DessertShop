package DessertShop;

import org.junit.jupiter.api.Test;

import DessertShop.Cookie;

import org.junit.Assert;


public class CookieTest {

    private void assertCookie(
            String expectedName,
            int expectedQuantity,
            double expectedPricePerDozen,
            Cookie Cookie) {
        Assert.assertEquals(expectedName, Cookie.getName());
        Assert.assertEquals(expectedPricePerDozen, Cookie.getPricePerDozen(), 0.01);
        Assert.assertEquals(expectedQuantity, Cookie.getQuantity(), 0.01);

    }

    @Test
    public void testDefaultConstructor() {
        Cookie Cookie = new Cookie();
        assertCookie(
                "Cookie",
                0,
                0,
                Cookie);
    }

    @Test
    public void testConstructorWithArguments() {
        Cookie Cookie = new Cookie("Chocolate", 1,1.0);
        assertCookie(
                "Chocolate",
                1,
                1.0,
                Cookie);
    } 

    @Test
    public void testGetQuantity() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                1,
                3.50);
        Assert.assertEquals(1, Cookie.getQuantity(),0.1);
    }

    @Test
    public void testSetQuantity() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                0,
                3.50);
        Cookie.setQuantity(1);
        Assert.assertEquals(1, Cookie.getQuantity(),0.1);
    }
    
    @Test
    public void testGetPricePerDozen() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                1,
                3.50);
        Assert.assertEquals(3.50, Cookie.getPricePerDozen(),0.1);
    }

    @Test
    public void testSetPricePerDozen() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                1,
                0);
        Cookie.setPricePerDozen(0.50);
        Assert.assertEquals(0.50, Cookie.getPricePerDozen(),0.1);
    }

    @Test
    public void testPricePerPoundDozenNegative() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                1,
                0);
        Cookie.setPricePerDozen(-1);
        Assert.assertNotEquals(-1, Cookie.getPricePerDozen(), 0.1);
    }

    @Test
    public void testSetQuantityNegative() {
        Cookie Cookie = new Cookie(
                "Chocolate Cookie",
                1,
                0);
        Cookie.setPricePerDozen(-1);
        Assert.assertNotEquals(-1, Cookie.getPricePerDozen(), 0.1);
    }
    @Test
    public void testCalculateCost() {
        Cookie cookie = new Cookie("Chocolate", 2, 3.5);
        Assert.assertEquals(0.58, cookie.calculateCost(), 0.001);
    }

    @Test
    public void testIsSame(){
        Cookie cookie = new Cookie("Chocolate", 2, 3.5);
        Cookie cookie2 = new Cookie("Chocolate", 2, 3.5);

        Assert.assertEquals(true, cookie.isSameAs(cookie2));
    }

}