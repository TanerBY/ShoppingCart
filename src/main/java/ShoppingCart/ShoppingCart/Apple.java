package ShoppingCart.ShoppingCart;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Apple implements CartItem {

	private final static BigDecimal price = new BigDecimal(0.60).setScale(2, RoundingMode.HALF_UP);

	@Override
	public BigDecimal getPrice() {
		return price;
	}

}
