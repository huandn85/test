package controller;

import entity.Account;
import entity.Category;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AccountService;
import service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "getAllCus", method = RequestMethod.GET)
    public String getall(Model model){
        List<Customer> customers= customerService.getAllCus();
        model.addAttribute("listCu", customers);
        return "admin/customerlist";
    }
    @RequestMapping(value = "reloadCus", method = RequestMethod.GET)
    public String reloadCu(Model model){
        model.addAttribute("customer" , new Customer());
        Map<Integer, String> accMap = new HashMap<>();
        List<Account> accounts = accountService.getAll();
        for (Account c : accounts) {
            accMap.put(c.getId(), c.getName());
        }
        model.addAttribute("accounts", accMap);
        return "admin/addcustomer";
    }
    @RequestMapping(value = "addCus", method = RequestMethod.POST)
    public String addCus(@ModelAttribute Customer customer, Model model){
        customerService.addCus(customer);
        return "getAllCus";
    }

}
