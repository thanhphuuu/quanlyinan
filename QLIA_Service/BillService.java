package QLIA_Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLIA_Model.Bill;
import QLIA_Repository.IBillRepository;

@Service
public class BillService {

    @Autowired
    private IBillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill updateBill(int id, Bill billDetails) {
        Bill bill = billRepository.findById(id)
                                   .orElseThrow(() -> new NoSuchElementException("Bill not found with id: " + id));

        bill.setBillName(billDetails.getBillName());
        bill.setBillStatus(billDetails.getBillStatus());
        bill.setTotalMoney(billDetails.getTotalMoney());
        bill.setProject(billDetails.getProject());
        bill.setCustomer(billDetails.getCustomer());
        bill.setTradingCode(billDetails.getTradingCode());
        bill.setCreateTime(billDetails.getCreateTime());
        bill.setUpdateTime(billDetails.getUpdateTime());
        bill.setEmployee(billDetails.getEmployee());
        return billRepository.save(bill);
    }
}
