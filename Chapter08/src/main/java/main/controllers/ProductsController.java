package main.controllers;

import main.entities.Product;
import main.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);

        model.addAttribute("products", productService.findAll());

        return "products.html";
    }
}
