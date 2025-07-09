package org.example.book.dalti_back.controller;

import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.entity.Service;
import org.example.book.dalti_back.repository.ServiceSpec;
import org.example.book.dalti_back.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody Service service) {
        return ResponseEntity.ok(serviceService.insert(service));
    }

    @GetMapping("/{id}")
    public Service findById(@PathVariable Long id) {
        return serviceService.findById(id);
    }

    @GetMapping()
    public List<Service> findAll() {
        return serviceService.findAll();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Service service){
        return ResponseEntity.ok(serviceService.update( service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){ //we can use void
        serviceService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{servId}/enrollTo/{categId}")
    public  ResponseEntity<?> enrollTo(@PathVariable Long servId, @PathVariable Long categId) {
        return ResponseEntity.ok(serviceService.enrollToCategory(servId, categId));
    }

    @DeleteMapping("/{servId}/enrollTo/{categId}")
    public void cancelEnrollToCateg(@PathVariable Long servId , @PathVariable Long categId) {
        serviceService.cancelEnrollToCateg(categId,servId);
    }


    @GetMapping("/{servId}/categories")
    public  ResponseEntity<?> getCategoriesByServiceId(@PathVariable Long servId) {
        return ResponseEntity.ok(serviceService.getCategoriesByServiceId(servId));
    }

    @GetMapping("/spec")
    public List<org.example.book.dalti_back.entity.Service> findServicesSpecName(@RequestParam String servName){
        return serviceService.findServicesSpecName(servName);
    }


}
