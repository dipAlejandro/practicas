package org.empresa.stockmanager.dao;

import java.util.List;

import org.empresa.stockmanager.entities.Product;

public interface ProductDAO {
	
	public int create(Product p);
	
	public Product selectById(Integer id);
	
	public List<Product> selectAll();
	
	public int update(Integer id, Product p);
	
	public int delete(Integer id);
	
}
