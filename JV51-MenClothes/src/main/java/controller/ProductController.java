package controller;

import dto.FileResponseDto;
import entity.Category;
import entity.File;
import entity.Product;

import entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.*;

import javax.annotation.processing.Messager;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StatusService statusService;


//    @RequestMapping("/")
//    public String adminpage() {
//  return "admin/TEST";
////        return "admin/Adminpage";
//    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("RqadMIN")
    public String AdminpageAndgettotal(Model model) {
        int Totalpro = productService.getTotalPro();
        System.out.println(Totalpro);
        model.addAttribute("Totalpro", Totalpro);
        int tatol = customerService.getTotal();
        System.out.println(tatol);
        model.addAttribute("total", tatol);
        int totalor = orderService.getTotalOr();
        model.addAttribute("totalor", totalor);
        int totalEPro = productService.getEmtyPro();
        model.addAttribute("totalEPro",totalEPro);
        return "admin/Adminpage";
    }

//    @RequestMapping(value="/viewemp/{pageid}")
//    public String edit(@PathVariable int pageid,Model m){
//        int total=10;
//        if(pageid==1){}
//        else{
//            pageid=(pageid-1)*total+1;
//        }
//        System.out.println(pageid);
//        List<Product> list=dao.getProductByPage(pageid,total);
//        m.addAttribute("msg", list);
//        return "admin/productlist";
//    }

    @RequestMapping(value = "listPro", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Product> lists = productService.getAllPro();
        model.addAttribute("lists", lists);
        return "admin/productlist";
    }
    @RequestMapping(value = "getEmty", method = RequestMethod.GET)
    public String getAllEmty(Model model) {
        List<Product> lists = productService.getAllEmties();
        model.addAttribute("listsemty", lists);
        return "admin/productlistemty";
    }

    @RequestMapping(value = "rqPro",method = RequestMethod.GET)
    public String rqPro( Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", new Category());
        model.addAttribute("status", new Status());
        Map<Integer, String> cateMap = new HashMap<>();
        List<Category> stores = categoryService.getAllCa();
        for (Category c : stores) {
            cateMap.put(c.getId(), c.getName());
        }
        model.addAttribute("categorys", cateMap);

        Map<Integer, String> staMap = new HashMap<>();
        List<Status> status = statusService.getAllSta();
        for (Status c : status) {
            staMap.put(c.getId(), c.getName());
        }
        model.addAttribute("sta", staMap);
        System.out.println("aaaaaaaabdabsdabdbasbdabsdbabsdabsd");
        return "admin/addproduct";
    }

    @RequestMapping(value = "*requesPr",method = RequestMethod.GET)
    public String rqProduct( Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", new Category());
        model.addAttribute("status", new Status());
        Map<Integer, String> cateMap = new HashMap<>();
        List<Category> stores = categoryService.getAllCa();
        for (Category c : stores) {
            cateMap.put(c.getId(), c.getName());
        }
        model.addAttribute("categorys", cateMap);

        Map<Integer, String> staMap = new HashMap<>();
        List<Status> status = statusService.getAllSta();
        for (Status c : status) {
            staMap.put(c.getId(), c.getName());
        }
        model.addAttribute("sta", staMap);
        System.out.println("aaaaaaaabdabsdabdbasbdabsdbabsdabsd");
        return "admin/addproduct";
    }

    @RequestMapping(value = "addproduct", method = RequestMethod.POST)
    public String addAProduct(@Valid @ModelAttribute Product product, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "redirect:rqproduct";
        } else {
            productService.addProduct(product);
            return "admin/productlist";
        }
    }

    @RequestMapping(value = "deleteId", method = RequestMethod.GET)
    public String deletePro(@RequestParam(name = "id") int id) {
        productService.deleteById(id);
        return "redirect:requestProduct";
    }


    @RequestMapping(value = "requestId", method = RequestMethod.GET)
    public String requestId(@RequestParam(name = "id") int id, Model model) {
        Product product = productService.getupdatePro(id);
        System.out.println("Categpory: " + product.getCategoryId().getName());
        model.addAttribute("product", product);
        return "admin/updateproduct";
}


    @RequestMapping(value = "updateP", method = RequestMethod.POST)
    public String updatePr(@ModelAttribute("product") Product product) {
        System.out.println("456");
        productService.updatePro(product);
        System.out.println("678");
        return "redirect:requestProduct";
    }
        @RequestMapping(value = "addCate",method = RequestMethod.POST)
        public String upcte(@ModelAttribute Category category){
        categoryService.addCate(category);
        return "redirect:rqproduct";
    }
    @RequestMapping(value = "addSta",method = RequestMethod.POST)
    public String upcte(@ModelAttribute Status status){
        statusService.addCate(status);
        return "redirect:rqproduct";
    }




}