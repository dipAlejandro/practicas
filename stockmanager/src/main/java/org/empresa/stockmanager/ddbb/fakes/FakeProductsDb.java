package org.empresa.stockmanager.ddbb.fakes;

import java.util.ArrayList;
import java.util.List;

import org.empresa.stockmanager.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public class FakeProductsDb {

    private List<Product> table;

    public FakeProductsDb() {
        this.table = new ArrayList<Product>();
        this.init();
    }

    protected void init() {
        Product p1 = new Product();
        p1.setId(0);
        p1.setName("Mochila");
        p1.setDescription("Mochila escolar carrito P");
        p1.setSection("Mochilas");
        p1.setPrice(21000.0);

        table.add(p1);
        
        Product p2 = new Product();
        p2.setId(1);
        p2.setName("Lapicera");
        p2.setDescription("Lapicera negra \"Bic\"");
        p2.setSection("Utiles");
        p2.setPrice(450);

        table.add(p2);
        
        Product p3 = new Product();
        p3.setId(2);
        p3.setName("Pegamento");
        p3.setDescription("Pegamento \"Boligoma\" 50 cc");
        p3.setSection("Utiles");
        p3.setPrice(650);

        table.add(p3);
    }

    public List<Product> getTable() {
        return table;
    }

	public List<Product> getEmptyTable() {
		table.clear();
		return table;
	}
}
