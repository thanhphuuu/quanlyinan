package QLIA_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import QLIA_Model.Delivery;
import QLIA_Service.DeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }
    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable int id, @RequestBody Delivery deliveryDetails) {
        Delivery updatedDelivery = deliveryService.updateDelivery(id, deliveryDetails);
        return ResponseEntity.ok(updatedDelivery);
    }
}
