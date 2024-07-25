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

import QLIA_Model.ShippingMethod;
import QLIA_Service.ShippingMethodService;

@RestController
@RequestMapping("/shipping-methods")
public class ShippingMethodController {
    @Autowired
    private ShippingMethodService shippingMethodService;
    @GetMapping
    public List<ShippingMethod> getAllShippingMethods() {
        return shippingMethodService.getAllShippingMethods();
    }
    @PostMapping
    public ShippingMethod createShippingMethod(@RequestBody ShippingMethod shippingMethod) {
        return shippingMethodService.createShippingMethod(shippingMethod);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ShippingMethod> updateShippingMethod(@PathVariable int id, @RequestBody ShippingMethod shippingMethodDetails) {
        ShippingMethod updatedShippingMethod = shippingMethodService.updateShippingMethod(id, shippingMethodDetails);
        return ResponseEntity.ok(updatedShippingMethod);
    } 
}
