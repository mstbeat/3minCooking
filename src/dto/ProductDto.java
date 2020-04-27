/**
* Copyright (c) Proud Data Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details. *
* THE SOFTWARE IS PROVIDED BY Proud Group
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. */

package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import dao.ProductDao;

/**
* 商品情報モデルを定義するクラス.
* @author Masato Yasuda
*/
public class ProductDto implements Serializable {

	/** 商品ID */
	private int productId;

	/** 商品名 */
    private String productName;

    /** ジャンル */
    private String genre;

    /** メーカー */
    private String maker;

    /** 販売価格 */
    private java.math.BigDecimal sellingPrice;

    /** 商品説明 */
    private String productDetail;

    /**
	* 商品情報を商品IDなしで転送するメソッド.
	* @param productId 商品ID
	* @param genre ジャンル
	* @param maker メーカー
	* @param productName 商品名
	* @param sellingPrice 販売価格
	* @param productDetail 商品説明
	*/
    public ProductDto(String genre, String maker, String productName, java.math.BigDecimal sellingPrice, String productDetail) {
    	this.genre = genre;
    	this.maker = maker;
    	this.productName = productName;
    	this.sellingPrice = sellingPrice;
    	this.productDetail = productDetail;
    }

    /**
	* 商品情報を商品IDと共に転送するメソッド.
	* @param productId 商品ID
	* @param genre ジャンル
	* @param maker メーカー
	* @param productName 商品名
	* @param sellingPrice 販売価格
	* @param productDetail 商品説明
	*/
    public ProductDto(int productId, String genre, String maker, String productName, java.math.BigDecimal sellingPrice, String productDetail) {
    	this.productId = productId;
    	this.genre = genre;
    	this.maker = maker;
    	this.productName = productName;
    	this.sellingPrice = sellingPrice;
    	this.productDetail = productDetail;
    }

    /**
	* 商品情報をデータベースに登録するメソッド.
	* @param productDto 商品情報データオブジェクト
	*/
    public void execute(ProductDto productDto) {
    	ProductDao dao = new ProductDao();
    	dao.create(productDto);
    }

    /**
	* ジャンルを列挙型で扱い、値とキーを戻すメソッド.
	* @return 列挙型 ジャンルの値とキー
	*/
    public enum Genre {
    	NONE(0, "指定なし"),
    	APPLIANCES(1, "家電"),
    	FURNITURE(2, "家具"),
    	FOOD(3, "食品"),
    	FASHION(4, "ファッション"),
    	BOOK(5, "書籍");

    	/** ジャンルの値 */
    	private int value;

    	/** ジャンルのキー */
    	private String key;

    	Genre(int value , String key){
	    	this.value=value;
	    	this.key = key;
    	}

    	/**
    	* 値を得るメソッド.
    	* @return ジャンルの値
    	*/
    	public int getValue() {
    		return value;
    	}

    	/**
    	* ジャンルの値を入れるメソッド.
    	*/
    	public void setValue(int value) {
    		this.value = value;
    	}

    	/**
    	* キーを得るメソッド.
    	* @return ジャンルのキー
    	*/
    	public String getKey() {
    		return key;
    	}

    	/**
    	* ジャンルのキーを入れるメソッド.
    	*/
    	public void setKey(String key) {
    		this.key = key;
    	}
    }

    /**
	* 商品IDを得るメソッド.
	* @return 商品ID
	*/
    public int getProductId() {
        return productId;
    }

    /**
	* 商品名を得るメソッド.
	* @return 商品名
	*/
    public String getProductName() {
    	return productName;
    }

    /**
	* ジャンルを得るメソッド.
	* @return ジャンル
	*/
    public String getGenre() {
    	return genre;
    }

    /**
	* メーカーを得るメソッド.
	* @return メーカー
	*/
    public String getMaker() {
    	return maker;
    }

    /**
	* 販売価格を得るメソッド.
	* @return 販売価格
	*/
    public BigDecimal getSellingPrice() {
    	return sellingPrice.setScale(0, RoundingMode.HALF_UP);
    }

    /**
	* 商品説明を得るメソッド.
	* @return 商品説明
	*/
    public String getProductDetail() {
    	return productDetail;
    }
}
