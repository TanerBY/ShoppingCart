package ShoppingCart.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {

	private static Map<String, CartItem> itemMap;
	private Map<CartItem, Long> cartItems;
	private static Map<Class<? extends CartItem>, Integer> offers;

	static {
		itemMap = new HashMap<String, CartItem>();
		itemMap.put("Apple", new Apple());
		itemMap.put("Orange", new Orange());

		offers = new HashMap<Class<? extends CartItem>, Integer>();
		offers.put(Apple.class, 2);
		offers.put(Orange.class, 3);
	}

	public ShoppingCart(List<String> items) {
		cartItems = new HashMap<CartItem, Long>();
		cartItems = items.stream().filter(s -> itemMap.containsKey(s))
				.collect(Collectors.groupingBy(o -> itemMap.get(o), Collectors.counting()));

		if (items.size() != cartItems.entrySet().stream().mapToLong(entry -> entry.getValue()).sum()) {
			throw new IllegalArgumentException();
		}
	}

	public BigDecimal calculateCost() {
		return cartItems.entrySet().stream().map(s -> s.getKey().getPrice().multiply(new BigDecimal(s.getValue())))
				.reduce(BigDecimal.ZERO, BigDecimal::add).subtract(calculateDiscounts());
	}

	private BigDecimal calculateDiscounts() {
		return cartItems.entrySet().stream().filter(s -> offers.containsKey(s.getKey().getClass())).map(
				s -> s.getKey().getPrice().multiply(new BigDecimal(s.getValue() / (offers.get(s.getKey().getClass())))))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
