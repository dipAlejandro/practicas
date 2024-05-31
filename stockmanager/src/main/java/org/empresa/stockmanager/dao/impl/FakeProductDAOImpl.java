package org.empresa.stockmanager.dao.impl;

import java.util.List;

import org.empresa.stockmanager.dao.ProductDAO;
import org.empresa.stockmanager.ddbb.fakes.FakeProductsDb;
import org.empresa.stockmanager.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeProductDAOImpl implements ProductDAO {
	@SuppressWarnings("unused")
	private int count = 0;
	@Autowired
	private FakeProductsDb fakeProductDb;

	@Override
	public Product selectById(Integer id) {
		if (id >= 0 && id < fakeProductDb.getTable().size()) {
			return fakeProductDb.getTable().get(id);
		} else {
			throw new IndexOutOfBoundsException("Invalid index: " + id);
		}
	}

	@Override
	public List<Product> selectAll() {

		/*
		 * if (count == 0) {//DEBUG: For Tests, should be delete after. count++;
		 * System.out.println("Showing an empty table"); return
		 * fakeProductDb.getEmptyTable();
		 * 
		 * } else {return fakeProductDb.getTable();
		 */
		
		return fakeProductDb.getTable();

	}

	@Override
	public int update(Integer id, Product p) {
		if (id >= 0 && id < fakeProductDb.getTable().size()) {
			fakeProductDb.getTable().set(id, p);
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {

		if (id.intValue() >= 0 && id < fakeProductDb.getTable().size()) {
			fakeProductDb.getTable().remove(id.intValue());
			return 1;
		}
		return 0;
	}

	@Override
	public int create(Product p) {
		p.setId(fakeProductDb.getTable().size());
		fakeProductDb.getTable().add(p);
		return p.getId();
	}
}
