package QLIA_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import QLIA_Model.Design;
import QLIA_Service.DesignService;

import java.util.List;

@RestController
@RequestMapping("/api/designs")
public class DesignController {

    @Autowired
    private DesignService designService;

    @GetMapping
    public List<Design> getAllDesigns() {
        return designService.getAllDesigns();
    }

    @PostMapping
    public Design createDesign(@RequestBody Design design) {
        return designService.createDesign(design);
    }

    @PutMapping("/approve/{id}")
    public Design approveDesign(@PathVariable int id) {
        return designService.approveDesign(id);
    }
}
