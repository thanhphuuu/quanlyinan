package QLIA_Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Customer;
import QLIA_Repository.ICustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                                              .orElseThrow(() -> new NoSuchElementException("Customer not found with id: " + id));

        customer.setFullName(customerDetails.getFullName());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setAddress(customerDetails.getAddress());

        return customerRepository.save(customer);
    }
}
