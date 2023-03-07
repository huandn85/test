package controller;

import entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrderDetailService;

import java.util.List;

@Controller
public class OrderDetailsController {
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "requestIdOr", method = RequestMethod.GET)
    public String getAllbyId(@RequestParam("id")int id , Model model){
        List<OrderDetails> orderDetails = orderDetailService.getODbyId(id);
        model.addAttribute("orderdetaillist",orderDetails);
        float totalAm = orderDetailService.getSumId(id);
        model.addAttribute("totalAm",totalAm);
        System.out.println(totalAm);
        System.out.println("oderdetail");
        return "admin/DetailOrder";
    }
}
