package shops;

import java.io.Serializable;

import store.IStock;

public abstract class Product  {

	public enum Brand implements Serializable {
		NIKE, ADIDAS, PUMA, EVERLAST
	}

	public enum Gender implements Serializable {
		MEN, LADIES
	}

	public enum ProductType implements Serializable{
		FOOTWEAR, CLOTHING, ACCESSORIES
	}
	public static String[] menFootSizes = {"39", "40", "41", "42", "43", "44", "45", "46"};
	public static String[] menClothSizes = {"S", "M", "L", "XL", "XXL"};
	public static String[] accessSizes = {"XS", "S", "M", "L"};
	public static String[] ladiesFootsizes ={"35", "36", "37", "38", "39", "40", "41", "42"};
	public static String[] ladiesClothSizes = {"XS", "S", "M", "L", "XL"};




	private String name;
	private Brand brand;
	private Gender gender;
	private double price;
	private String productInfo;
	private String color;
	private String size;
	private int image;
	private int quantity;
	protected ProductType productType;
	protected IStock stock;

	public Product(String name, Brand brand,int image, Gender gender, double price, String productInfo, String color, String size, int quantity) {

		this.name = name;
		this.brand = brand;
		this.image = image;
		this.gender = gender;
		this.productInfo = productInfo;
		this.price = price;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
	}
	
	public Gender getGender() {
		return gender;
	}

	public ProductType getProductType() {
		return productType;
	}

	public IStock getStock() {
		return stock;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getImage() {
		return image;
	}


	@Override
	public String toString() {
		return " " + this.brand + " " + this.name + ", price:" + price +", color" +color +
				", size " + size + ", quantity "+ quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		return Double.compare(product.price, price) == 0;

	}

	@Override
	public int hashCode() {
		long temp = Double.doubleToLongBits(price);
		return (int) (temp ^ (temp >>> 32));
	}

	public String getSize() {
		return size;
	}
	public String getColor() {
		return color;
	}


	
	

}
