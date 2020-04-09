package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import dao.ProductDao;

public class ProductDto implements Serializable {
	private int productId;
    private String productName;
    private String genre;
    private String maker;
    private java.math.BigDecimal sellingPrice;
    private String productDetail;

    public ProductDto(String genre, String maker, String productName, java.math.BigDecimal sellingPrice, String productDetail) {
    	this.genre = genre;
    	this.maker = maker;
    	this.productName = productName;
    	this.sellingPrice = sellingPrice;
    	this.productDetail = productDetail;
    }

    public ProductDto(int productId, String genre, String maker, String productName, java.math.BigDecimal sellingPrice, String productDetail) {
    	this.productId = productId;
    	this.genre = genre;
    	this.maker = maker;
    	this.productName = productName;
    	this.sellingPrice = sellingPrice;
    	this.productDetail = productDetail;
    }

    public int getProductId() {
        return productId;
    }
    public String getProductName() {
    	return productName;
    }
    public String getGenre() {
    	return genre;
    }
    public String getMaker() {
    	return maker;
    }
    public BigDecimal getSellingPrice() {
    	return sellingPrice.setScale(0, RoundingMode.HALF_UP);
    }
    public String getProductDetail() {
    	return productDetail;
    }

    public void execute(ProductDto productDto) {
    	ProductDao dao = new ProductDao();
    	dao.create(productDto);
    }

    public enum Genre {
    	NONE(0, "指定なし"),
    	APPLIANCES(1, "家電"),
    	FURNITURE(2, "家具"),
    	FOOD(3, "食品"),
    	FASHION(4, "ファッション"),
    	BOOK(5, "書籍");

    	private int value;
    	private String key;

    	Genre(int value , String key){
	    	this.value=value;
	    	this.key = key;
    	}

    	public int getValue() {
    		return value;
    	}

    	public void setValue(int value) {
    		this.value = value;
    	}

    	public String getKey() {
    		return key;
    	}

    	public void setKey(String key) {
    		this.key = key;
    	}
    }
}
