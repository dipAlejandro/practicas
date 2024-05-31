package org.empresa.stockmanager.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.empresa.stockmanager.dao.ProductDAO;
import org.empresa.stockmanager.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

	private final ProductDAO fakeDao;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	public ProductController(ProductDAO fakeDao) {
		this.fakeDao = fakeDao;
	}

	@GetMapping(value = { "/", "/products" })
	public String showProducts(Model model) {
		logger.info("[GET] Showing products");

		model.addAttribute("products", fakeDao.selectAll());

		// model.addAttribute("products", new ArrayList<Product>());

		return "showProducts";
	}

	@GetMapping("/products/{id}")
	public String showProductDetail(@PathVariable(value = "id") Integer id, Model model) {
		logger.info("[GET] Product {} detail", id);
		model.addAttribute("product", fakeDao.selectById(id));
		return "productDetail";
	}

	@GetMapping("/products/new")
	public String newProduct(Model model) {
		logger.info("[GET] Showing new products form");

		Map<String, Object> attrs = new HashMap<String, Object>();

		attrs.put("sections", Arrays.asList("Oficina", "Papeleria", "Utiles", "Mochilas"));
		attrs.put("product", new Product());

		model.addAllAttributes(attrs);

		return "newProductForm";
	}

	@PostMapping("/products/new/")
	public String createProduct(@ModelAttribute("newProduct") Product p, RedirectAttributes redirectAttributes) {

		logger.info("[POST] Trying to add new product");

		if (p != null && fakeDao.create(p) >= 0) {

			redirectAttributes.addFlashAttribute("message", "Product added successfully!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			logger.info("[POST] New product added " + p.toString());

		} else {
			redirectAttributes.addFlashAttribute("message", "Error adding product.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			logger.warn("[POST] An error has occurred while trying to add a new Product");
		}
		return "redirect:/products/new";
	}

	@GetMapping("/products/update/{id}")
	public String updateProduct(@PathVariable(value = "id") Integer id, Model model) {
		logger.info("[GET] Showing update form");
		Map<String, Object> attrs = new HashMap<String, Object>();

		List<String> sections = Arrays.asList("Oficina", "Papeleria", "Utiles", "Mochilas");

		attrs.put("sections", sections);
		attrs.put("product", fakeDao.selectById(id));

		model.addAllAttributes(attrs);

		return "updateProductForm";
	}

	@PostMapping("/products/saveupdate")
	public String saveUpdate(@ModelAttribute("product") Product p, Model model) {

		logger.info("[POST] Trying to update product {}", p.getId());

		if (fakeDao.update(p.getId(), p) > 0) {
			logger.info("[POST] The product {} has been updated successfully", p.getId());
			model.addAttribute("productUpdated", p);

			return "saveUpdate";

		} else {

			model.addAttribute("message", "An error has occurred while trying to update product " + p.getId());

			logger.warn("[POST] An error has occurred while trying to update Product");

			return "redirect:/";
		}
	}

	@PostMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes) {
		logger.info("[DELETE] Trying to delete product {}", id);
		// Map<String, String> attrs = new HashMap<String, String>();

		if (fakeDao.delete(id) > 0) {
			logger.info("[DELETE] The product " + id + " was removed successfully");

			// attrs.put("message", "The product " + id + " was removed successfully");
			// attrs.put("alertClass", "alert-success");

		} else {

			// attrs.put("message", "An error has occurred while trying to delete the
			// Product " + id);
			// attrs.put("alertClass", "alert-danger");

			logger.warn("[DELETE] An error has occurred while trying to delete the Product " + id);
		}

		// redirectAttributes.addAllAttributes(attrs);

		return "redirect:/products";
	}
}
