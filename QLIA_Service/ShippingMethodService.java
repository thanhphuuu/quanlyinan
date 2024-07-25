package QLIA_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import QLIA_Model.ShippingMethod;
import QLIA_Repository.IShippingMethodRepository;

@Service
public class ShippingMethodService {
    @Autowired
    private IShippingMethodRepository shippingMethodRepository;

    public List<ShippingMethod> getAllShippingMethods() {
        return shippingMethodRepository.findAll();
    }
    public ShippingMethod createShippingMethod(ShippingMethod shippingMethod) {
        return shippingMethodRepository.save(shippingMethod);
    }
    public ShippingMethod updateShippingMethod(int id, ShippingMethod shippingMethodDetails) {
        ShippingMethod shippingMethod = shippingMethodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Shipping Method not found with id: " + id));

        shippingMethod.setShippingMethodName(shippingMethodDetails.getShippingMethodName());

        return shippingMethodRepository.save(shippingMethod);
    }
    public void deleteShippingMethod(int id) {
        if (!shippingMethodRepository.existsById(id)) {
            throw new NoSuchElementException("Shipping Method not found with id: " + id);
        }
        shippingMethodRepository.deleteById(id);
    }
    public ShippingMethod getShippingMethodById(int id) {
        return shippingMethodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Shipping Method not found with id: " + id));
    }
}
