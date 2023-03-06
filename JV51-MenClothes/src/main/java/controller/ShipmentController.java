package controller;

import entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ShipmentService;

@Controller
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @RequestMapping(value = "requestID", method = RequestMethod.GET)
    public String getInforShip(@RequestParam(name = "id") int id , Model model){
        Shipment shipment = shipmentService.getShip(id);
        model.addAttribute("shipment", shipment);
        return "admin/SearchOrderByName";
    }

}
