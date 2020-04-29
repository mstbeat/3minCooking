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

/**
 * 商品情報モデルを定義するクラス.
 * @author Masato Yasuda
 */
public class ProductDto implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 商品ID */
	private int productId;

	/** 商品名 */
    private String productName;

    /** ジャンル */
    private String genre;

    /** メーカー */
    private String maker;

    /** 販売価格 */
    private BigDecimal sellingPrice;

    /** 商品説明 */
    private String productDetail;

    /**
     * デフォルトコンストラクタ
     */
    public ProductDto() {
    }

    /**
	 * ジャンルを列挙型で扱い、値とキーを戻すメソッド.
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
    	 * キーを得るメソッド.
    	 * @return ジャンルのキー
    	 */
    	public String getKey() {
    		return key;
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

    /**
   	 * 商品IDのセッターメソッド.
   	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}


    /**
	 * 商品名のセッターメソッド.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * ジャンルのセッターメソッド.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * メーカーのセッターメソッド.
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * 販売価格のセッターメソッド.
	 */
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	 /**
	 * 商品説明のセッターメソッド.
	 */
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
    
    
}
