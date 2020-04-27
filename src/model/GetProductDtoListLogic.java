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

package model;

import java.util.List;

import dao.ProductDao;
import dto.ProductDto;

/**
* 商品情報一覧を生成するロジックを定義するクラス.
* @author Masato Yasuda
*/
public class GetProductDtoListLogic {

	/**
	* 商品情報一覧をList型で戻すメソッド.
	* @return 商品情報一覧
	*/
	public List<ProductDto> execute() {
   		ProductDao dao = new ProductDao();
   		List<ProductDto> productDtoList = dao.findAll();
   		return productDtoList;
   	}
}
