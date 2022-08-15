package bened.productsapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import bened.productsapi.model.Product;

import java.util.HashMap;

@Controller
public class ProductsController {
    static HashMap<Integer, Product> productRepo = new HashMap<>();

    static {
        Product corn = new Product();
        corn.setId(1);
        corn.setCrop("corn");
        corn.setName("usa michigan corn");
        productRepo.put(1, corn);

        Product soy = new Product();
        soy.setId(2);
        soy.setCrop("soy");
        soy.setName("usa nebraska soy");
        productRepo.put(2, soy);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-data");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(value="/viewById", method = RequestMethod.GET)
    public ModelAndView viewById(
        @RequestParam(value = "id", required = true) Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-data");
        modelAndView.addObject("product", productRepo.get(id));
        return modelAndView; //1:43:44
    }
}
