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
		BigDecimal expectedCost = new BigDecimal(1.45).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test
	public void shouldCalculateCostOfShoppingCartWithOneAppleItem() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Apple"));
		BigDecimal expectedCost = new BigDecimal(0.60).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test
	public void shouldCalculateCostOfShoppingCartWithOneOrangeItem() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Orange"));
		BigDecimal expectedCost = new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionIfProductNotFound() {
		new ShoppingCart(Arrays.asList("Apple", "Orange", "Banana"));
	}

	@Test
	public void shouldCalculateAppleDiscount() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Apple", "Apple"));
		BigDecimal expectedCost = new BigDecimal(0.60).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

	@Test
	public void shouldCalculateOrangeDiscount() {
		ShoppingCart cart = new ShoppingCart(Arrays.asList("Orange", "Orange", "Orange"));
		BigDecimal expectedCost = new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP);

		assertEquals(expectedCost, cart.calculateCost());
	}

}
