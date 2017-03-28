package shops;

import java.io.Serializable;

import store.IStock;
import tonchev.sportsdirect.R;

public class Accessories extends shops.Product {
	public enum AccessType implements IStock, Serializable{
		BELTS,GLASSES,WATCHES,HATS
	}
	private AccessType accessType;

	public Accessories(String name, shops.Product.Brand brand, Gender gender, double price, String productInfo, AccessType acessType, String color, String size, int quantity) {
		super(name, brand, gender,price, productInfo, color, size, quantity, R.drawable.acces);
		this.accessType = accessType;
		this.productType = ProductType.ACCESSORIES;
		this.stock = acessType;
	}
}
