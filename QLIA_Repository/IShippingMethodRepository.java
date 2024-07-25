package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.ShippingMethod;

@Repository
public interface IShippingMethodRepository extends JpaRepository<ShippingMethod, Integer> {
}