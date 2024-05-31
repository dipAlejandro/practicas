package org.empresa.stockmanager.controllers;

import java.io.IOException;

import org.empresa.stockmanager.dao.ProductDAO;
import org.empresa.stockmanager.services.ProductPDFService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/products")
public class ProductPDFController {

	private ProductDAO fakeDao;
	private static Logger logger = LoggerFactory.getLogger(ProductPDFController.class);
	private ProductPDFService pdfService;

	@Autowired
	public ProductPDFController(ProductDAO fd, ProductPDFService pdfs) {
		this.fakeDao = fd;
		this.pdfService = pdfs;
	}

	@GetMapping("/convert/pdf")
	public void generatePdf(HttpServletResponse httpServletResponse) {

		try {
			logger.info("[POST] Trying to convert table to PDF");
			pdfService.generatePdf(httpServletResponse, fakeDao.selectAll(),
					new String[] { "ID", "Name", "Section", "Price", "Description" }, "products");

		} catch (IOException e) {
			logger.error("Error while creating empty PDF", e);
			e.printStackTrace();
		}
	}
}
