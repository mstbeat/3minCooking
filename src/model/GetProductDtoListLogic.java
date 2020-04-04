package model;

import java.util.List;

import dao.ProductDao;
import dto.ProductDto;

public class GetProductDtoListLogic {
	public List<ProductDto> execute() {
   		ProductDao dao = new ProductDao();
   		List<ProductDto> productDtoList = dao.findAll();
   		return productDtoList;
   	}
}
