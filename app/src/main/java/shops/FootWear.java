package shops;

import java.io.Serializable;

import store.IStock;
import tonchev.sportsdirect.R;

public class FootWear extends Product {

	public enum ShoesType implements IStock, Serializable{
	RUNNIG,BOOTS,SANDALS,FLIPFLOPS,FOOTBALL

	}
	
	private ShoesType shoesType;

	public FootWear(String name, Brand brand, Gender gender, double price , String productInfo,	ShoesType shoesType, String color, String size, int quantity) {
		super(name, brand, gender,price, productInfo, color, size, quantity, R.drawable.run1 );
		this.shoesType = shoesType;
		this.productType = ProductType.FOOTWEAR;
		this.stock = shoesType;

	}


}
