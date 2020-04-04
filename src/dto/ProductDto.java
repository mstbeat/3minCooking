package dto;

import java.io.Serializable;
import java.math.BigDecimal;

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
    	return sellingPrice;
    }
    public String getProductDetail() {
    	return productDetail;
    }

    public void execute(ProductDto productDto) {
    	ProductDao dao = new ProductDao();
    	dao.create(productDto);
    }
}
