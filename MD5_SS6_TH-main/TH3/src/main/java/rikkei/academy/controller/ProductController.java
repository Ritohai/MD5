package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Cart;
import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return  new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView getProduct() {
        return new ModelAndView("/shop","products",productService.findAll());
    }
    @GetMapping("/add/{id}")
    public String AddToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("increase")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }else if (action.equals("decrease")){
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
