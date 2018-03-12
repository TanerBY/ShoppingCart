package ShoppingCart.ShoppingCart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void shouldCalculateCostOfShoppingCart() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Apple", "Apple", "Orange", "Apple"));
		BigDecimal expectedCost = new BigDecimal(2.05).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test
	public void shouldCalculateCostOfShoppingCartWithOneItem() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Apple"));
		BigDecimal expectedCost = new BigDecimal(0.60).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfProductNotFound() {
		new ShoppingCart(Arrays.asList("Apple", "Orange", "Banana"));
	}

}
