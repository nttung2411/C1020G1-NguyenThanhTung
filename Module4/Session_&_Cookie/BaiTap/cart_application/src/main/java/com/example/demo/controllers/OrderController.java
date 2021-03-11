package com.example.demo.controllers;


import com.example.demo.models.Cart;
import com.example.demo.models.OrderProduct;
import com.example.demo.models.OrderProductDetail;
import com.example.demo.models.Product;
import com.example.demo.service.OrderProductService;
import com.example.demo.service.OrderProductDetailService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class OrderController {
    @Autowired
    OrderProductService orderProductService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductDetailService orderProductDetailService;

    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @GetMapping("/{id}/addtocart")
    public String addToCart(@PathVariable Integer id,
                            RedirectAttributes redirectAttributes,@ModelAttribute Cart cart){
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(1);
        orderProductService.createOrder(orderProduct);

        Product product = productService.findById(id);

        OrderProductDetail orderProductDetail = new OrderProductDetail(product,orderProduct);
        orderProductDetailService.create(orderProductDetail);

        cart.add(orderProductDetail);

        redirectAttributes.addFlashAttribute("message","Added to orderProductDetail");
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String showCart(Model model,@ModelAttribute Cart cart){
        model.addAttribute("orderList",cart.getOrderProductDetails());
        return "showcart";
    }

    @GetMapping("/updateCart")
    public String updateCart(@RequestParam String string,@ModelAttribute Cart cart){
        String[] array = string.split(",");

        Integer id = Integer.parseInt(array[0]);

        Integer calculation = Integer.parseInt(array[1]);

        for(OrderProductDetail orderProductDetail : cart.getOrderProductDetails()){
            if (orderProductDetail.getIdOrderProductDetail() == id){

                OrderProduct orderProduct = orderProductDetail.getOrderProduct();

                if(calculation == -1 && orderProduct.getQuantity() > 1){
                    orderProduct.setQuantity(orderProduct.getQuantity()-1);
                    orderProductDetail.setOrderProduct(orderProduct);
                }else if(calculation == -2){
                    orderProduct.setQuantity(orderProduct.getQuantity()+1);
                    orderProductDetail.setOrderProduct(orderProduct);
                }else {
                    orderProduct.setQuantity(calculation);
                    orderProductDetail.setOrderProduct(orderProduct);
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam Integer id,@ModelAttribute Cart cart){

        if (id != -1) {
            for (int i = 0; i < cart.getOrderProductDetails().size(); i++) {

                OrderProductDetail orderProductDetail = cart.getOrderProductDetails().get(i);

                if (orderProductDetail.getIdOrderProductDetail() == id) {

                    OrderProduct orderProduct = orderProductDetail.getOrderProduct();

                    orderProductDetailService.deleteOrderProductDetail(id);
                    orderProductService.deleteOrder(orderProduct);

                    cart.getOrderProductDetails().remove(i);

                }
            }
        }else {
            cart.setOrderProductDetails(new ArrayList<>());
        }
        return "redirect:/cart";
    }
}
