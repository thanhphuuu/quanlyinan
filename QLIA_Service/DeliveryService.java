package QLIA_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Customer;
import QLIA_Model.Delivery;
import QLIA_Model.Project;
import QLIA_Model.ShippingMethod;
import QLIA_Model.User;
import QLIA_Repository.ICustomerRepository;
import QLIA_Repository.IDeliveryRepository;
import QLIA_Repository.IProjectRepository;
import QLIA_Repository.IShippingMethodRepository;
import QLIA_Repository.IUserRepository;

import java.util.NoSuchElementException;
import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private IDeliveryRepository deliveryRepository;
    @Autowired
    private IShippingMethodRepository shippingMethodRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IProjectRepository projectRepository;
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
    public Delivery createDelivery(Delivery delivery) {
        ShippingMethod shippingMethod = shippingMethodRepository.findById(delivery.getShippingMethod().getId())
                .orElseThrow(() -> new NoSuchElementException("Shipping Method not found"));
        Customer customer = customerRepository.findById(delivery.getCustomer().getId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        User deliver = userRepository.findById(delivery.getDeliver().getId())
                .orElseThrow(() -> new NoSuchElementException("Deliver not found"));

        Project project = projectRepository.findById(delivery.getProject().getId())
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
        delivery.setShippingMethod(shippingMethod);
        delivery.setCustomer(customer);
        delivery.setDeliver(deliver);
        delivery.setProject(project);
        return deliveryRepository.save(delivery);
    }
    public Delivery updateDelivery(int id, Delivery deliveryDetails) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Delivery not found with id: " + id));
        ShippingMethod shippingMethod = shippingMethodRepository.findById(deliveryDetails.getShippingMethod().getId())
                .orElseThrow(() -> new NoSuchElementException("Shipping Method not found"));
        Customer customer = customerRepository.findById(deliveryDetails.getCustomer().getId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        User deliver = userRepository.findById(deliveryDetails.getDeliver().getId())
                .orElseThrow(() -> new NoSuchElementException("Deliver not found"));
        Project project = projectRepository.findById(deliveryDetails.getProject().getId())
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
        delivery.setDeliveryAddress(deliveryDetails.getDeliveryAddress());
        delivery.setEstimateDeliveryTime(deliveryDetails.getEstimateDeliveryTime());
        delivery.setActualDeliveryTime(deliveryDetails.getActualDeliveryTime());
        delivery.setDeliveryStatus(deliveryDetails.getDeliveryStatus());
        delivery.setShippingMethod(shippingMethod);
        delivery.setCustomer(customer);
        delivery.setDeliver(deliver);
        delivery.setProject(project);
        return deliveryRepository.save(delivery);
    }
}