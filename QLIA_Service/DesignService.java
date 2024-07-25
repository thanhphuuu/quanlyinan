package QLIA_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import QLIA_Model.Design;
import QLIA_Repository.IDesignRepository;

@Service
public class DesignService {
    @Autowired
    private IDesignRepository designRepository;

    public List<Design> getAllDesigns() {
        return designRepository.findAll();
    }
    public Design createDesign(Design design) {
        return designRepository.save(design);
    }
    public Design approveDesign(int id) {
        Design design = designRepository.findById(id)
                                        .orElseThrow(() -> new NoSuchElementException("Design not found with id: " + id));
        design.setApproved(true);
        return designRepository.save(design);
    }
}