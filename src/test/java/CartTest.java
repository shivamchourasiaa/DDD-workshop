import com.thoughtworks.domain.Cart;
import com.thoughtworks.domain.Item;
import com.thoughtworks.domain.Price;
import com.thoughtworks.domain.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.thoughtworks.domain.constants.ProductName.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//Problem
// #1 : Add a “IPad Pro” to a com.thoughtworks.domain.Cart
// #2: Add a “Hero ink Pen” to a com.thoughtworks.domain.Cart
// #3: Add 2 qty “GM Cricket bat” to com.thoughtworks.domain.Cart.
// #4: Remove already added com.thoughtworks.domain.Item “Apple Pencil” (with all its quantities) from com.thoughtworks.domain.Cart. cart.remove(product)
//#6: As a business User, I would like to differentiate between two Carts.*  Two carts where items are same, equality on Carts should return false

// #5: As a business User I would like to know which Products (product name) were removed from com.thoughtworks.domain.Cart.

// #7:Add com.thoughtworks.domain.Price to a Product. We need support for only one currency, say - USD.
        //    Note:  For modelling currency - Please use java.util.Currency (Currency.getInstance("USD"))
        //    or what your programming language provides, if none just use String for now.
        //    new Product("Apple Pencil", new com.thoughtworks.domain.Price(...));

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
}
