package ShoppingCart.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

	private static Map<String, CartItem> itemMap;
	private List<CartItem> cartItems;

	static {
		itemMap = new HashMap<String, CartItem>();
		itemMap.put("Apple", new Apple());
		itemMap.put("Orange", new Orange());
	}

	public ShoppingCart(List<String> items) {
		cartItems = new ArrayList<CartItem>();
		items.stream().filter(s -> itemMap.containsKey(s)).forEach(s -> cartItems.add(itemMap.get(s)));

		if (items.size() != cartItems.size()) {
			throw new IllegalArgumentException();
		}
	}

	public BigDecimal calculateCost() {
		return cartItems.stream().map(s -> s.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
