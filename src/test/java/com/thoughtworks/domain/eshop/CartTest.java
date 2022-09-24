package com.thoughtworks.domain.eshop;

import com.thoughtworks.domain.eshop.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.thoughtworks.domain.eshop.constants.ProductName.*;
import static org.junit.jupiter.api.Assertions.*;

//Problem
// #1 : Add a “IPad Pro” to a com.thoughtworks.domain.eshop.Cart
// #2: Add a “Hero ink Pen” to a com.thoughtworks.domain.eshop.Cart
// #3: Add 2 qty “GM Cricket bat” to com.thoughtworks.domain.eshop.Cart.
// #4: Remove already added com.thoughtworks.domain.eshop.Item “Apple Pencil” (with all its quantities) from com.thoughtworks.domain.eshop.Cart. cart.remove(product)
//#6: As a business User, I would like to differentiate between two Carts.*  Two carts where items are same, equality on Carts should return false

// #5: As a business User I would like to know which Products (product name) were removed from com.thoughtworks.domain.eshop.Cart.

// #7:Add com.thoughtworks.domain.eshop.Price to a Product. We need support for only one currency, say - USD.
//    Note:  For modelling currency - Please use java.util.Currency (Currency.getInstance("USD"))
//    or what your programming language provides, if none just use String for now.
//    new Product("Apple Pencil", new com.thoughtworks.domain.eshop.Price(...));

// #8 - As a Business User I would like to price my product 10% below competitor price (competitor price is available for product) .
//        Assume that HashMap of Competitor Product Name and price is available. Competitor name matches 1 to 1 with our Product Name
//        new Product( "name", Price(discountedPrice, "USD"))
//        new Product( "name", Price(10.00, "USD"))


//#9  Create Order( with Products) when Cart is checked out. Also, Mark cart as checked out.
//        While Creating Order please do not use Item class but use Product class.
//        Flatten out products in Item.
//        'new Order( List<Product> products)

public class CartTest {
    static Cart cart;

    @BeforeAll
    static void beforeAll() {
        cart = new Cart();

    }

    @Test
    void shouldAddIpadProToTheCart() {

        Product ipadPro = new Product(I_PAD_PRO);

        cart.add(new Item(ipadPro));
        assertEquals(1, cart.getQuantityOf(I_PAD_PRO));
    }

    @Test
    void shouldAddHeroInkPenToTheCart() {

        Product pen = new Product(HERO_INK_PEN);
        cart.add(new Item(pen));
        assertEquals(1, cart.getQuantityOf(HERO_INK_PEN));
    }

    @Test
    void shouldAdd2GmBatsToTheCart() {

        Item bat = new Item(new Product(GM_BAT));
        cart.add(bat);
        cart.add(bat);

        assertEquals(2, cart.getQuantityOf(GM_BAT));
    }

    @Test
    void shouldRemoveApplePencilFromTheCart() {

        Item applePencil = new Item(new Product(APPLE_PENCIL));
        cart.add(applePencil);

        cart.remove(applePencil);
        assertEquals(0, cart.getQuantityOf(APPLE_PENCIL));
    }

    @Test
    void shouldFalseWhenTwoCartsAreComparedWithSameItems() {
        Cart cart2 = new Cart();
        Item item1 = new Item((new Product(I_PAD_PRO)));
        Item item2 = new Item((new Product(I_PAD_PRO)));

        cart.add(item1);
        cart2.add(item2);

        assertNotEquals(cart, cart2);
    }

    @Test
    void shouldAddIpadProWithPriceOf10USDToTheCart() {

        Product ipadPro = new Product(I_PAD_PRO, new Price(10.0));
        cart.add(new Item(ipadPro));
    }

    @Test
    void shouldAddIpaProWithThePriceLessThanCompetitorsPriceToTheCart() {
        Product ipadPro = Product.getProductWithDiscount(I_PAD_PRO);
        assertEquals(new Price(1.0).getAmount(), ipadPro.getPrice().getAmount());

    }

    @Test
    void shouldCreateOrderWhenCartIsCheckout() {
        Product ipadPro = new Product(I_PAD_PRO, new Price(10.0));
        cart.add(new Item(ipadPro));

        Order order = cart.checkout();

        assertTrue(cart.isCheckedOut());
    }
}
