package controller;

import entity.Order;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.OrderService;
import service.ProductService;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public String getAllOr(Model model){
        List<Order> orderList = orderService.getAll();
        model.addAttribute("OrderList", orderList);
        return "admin/Orderlist";
    }
    @RequestMapping(value = "requestOr", method = RequestMethod.GET)
    public String requestOr(Model model){
        model.addAttribute("order", new Order());
        return "admin/addOrder";
    }
    @RequestMapping(value = "addorder", method = RequestMethod.POST)
    public String addOr(@ModelAttribute Order order){
        orderService.addOrder(order);
        return "admin/Orderlist";
    }
    @RequestMapping(value = "findDate", method = RequestMethod.POST)
    public String searchDate(@RequestParam("name")String date1 ,@RequestParam("name1") String date2, Model model){
        List<Order> oderList = orderService.findBydate(date1,date2);
        System.out.println(date2);
        System.out.println("aaaaaa111111111");
        model.addAttribute("orders",oderList);
        return "admin/SearchOrderByName";
    }

}
