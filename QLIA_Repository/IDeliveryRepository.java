package QLIA_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLIA_Model.Delivery;
@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Integer> {
}
