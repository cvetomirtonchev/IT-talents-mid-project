package shops;

import java.io.Serializable;

import store.IStock;

public class Accessories extends shops.Product {
	public enum AccessType implements IStock, Serializable{
		BELTS,GLASSES,WATCHES,HATS
	}
	private AccessType accessType;

	public Accessories(String name,shops.Product.Brand brand,int image, Gender gender, double price, String productInfo, AccessType acessType, String color, String size, int quantity) {
		super(name, brand,image, gender,price, productInfo, color, size, quantity  );
		this.accessType = accessType;
		this.productType = ProductType.ACCESSORIES;
		this.stock = acessType;
	}
}
