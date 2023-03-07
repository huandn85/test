package controller;

import entity.Customer;
import entity.Order;
import entity.Product;
import entity.Shipment;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;
import service.OrderService;
import service.ProductService;
import service.ShipmentService;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ShipmentService shipmentService;

    @RequestMapping(value = "requestsear", method = RequestMethod.GET)
    public String toSear(){
        return "admin/SearchOrderByName";
    }

    @RequestMapping(value = "SearchAc", method = RequestMethod.POST)
    public String getAllSearch(@RequestParam(name = "name") String name , Model model){
        List<Order> orders = orderService.getAllSearch(name);
        System.out.println("acccccc");
        model.addAttribute("orders", orders);
        System.out.println(orders.toString());
        return "admin/SearchOrderByName";
    }
    @RequestMapping(value = "productget", method = RequestMethod.POST)
    public String getAlSearch(@RequestParam (name = "name") String name ,Model model){
        List<Product> product = productService.getSearch(name);
        System.out.println("accccccd");
        model.addAttribute("product", product);
        System.out.println(product.toString());
        return "admin/SearchOrderByName";
    }
    @RequestMapping(value = "cusall", method = RequestMethod.POST)
    public String getallCus(@RequestParam(name = "name") String name ,Model model){
        List<Customer> customers = customerService.getAll(name);
        model.addAttribute("customers", customers);
        System.out.println(customers.toString());
        return "admin/SearchOrderByName";
    }
    @RequestMapping(value = "shipadd", method = RequestMethod.POST)
    public String getAllsh(@RequestParam(name = "name")String name , Model model){
        List<Shipment> shipments = shipmentService.getAll(name);
        model.addAttribute("shipments", shipments);
        return "admin/SearchOrderByName";
    }

}
