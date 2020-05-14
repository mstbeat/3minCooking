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
	private static final long serialVersionUID = 42L;

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
	 * @param productId 商品ID
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * 商品名のセッターメソッド.
	 * @param productName 商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * ジャンルのセッターメソッド.
	 * @param genre ジャンル
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * メーカーのセッターメソッド.
	 * @param maker メーカー
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * 販売価格のセッターメソッド.
	 * @param sellingPrice 販売価格
	 */
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * 商品説明のセッターメソッド.
	 * @param productDetail 商品説明
	 */
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

}
