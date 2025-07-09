package org.example.book.dalti_back.service;

//import org.example.book.dalti_back.entity.Service;
import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.repository.CategoryRepo;
import org.example.book.dalti_back.repository.ServiceRepo;
import org.example.book.dalti_back.repository.ServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private CategoryRepo categoryRepo;
                //cuz Service id an Annotation
    public List<org.example.book.dalti_back.entity.Service> findAll() {
        return serviceRepo.findAll();
    }

    public org.example.book.dalti_back.entity.Service findById(Long id) {
        return serviceRepo.findById(id).orElse(null);
    }

    org.example.book.dalti_back.entity.Service serv = new org.example.book.dalti_back.entity.Service();
    public org.example.book.dalti_back.entity.Service enrollToCategory(
            Long categoryId ,
            Long serviceId
    ) {
            serv = serviceRepo.findById(serviceId).orElse(null);
            Category categ = categoryRepo.findById(categoryId).orElse(null);
            serv.getCategories().add(categ);
            return serviceRepo.save(serv);

    }

    public void cancelEnrollToCateg(Long categoryId , Long serviceId) {
        serv = serviceRepo.findById(serviceId).orElse(null);
        Category categ = categoryRepo.findById(categoryId).orElse(null);
        serv.getCategories().remove(categ);
        categ.getServices().remove(serv);
        serviceRepo.save(serv);
    }

    public org.example.book.dalti_back.entity.Service insert(org.example.book.dalti_back.entity.Service service) {
        return serviceRepo.save(service);
    }

    public org.example.book.dalti_back.entity.Service update(org.example.book.dalti_back.entity.Service service) {
        return serviceRepo.save(service);
    }

    public void deleteById(Long id) {
        serviceRepo.deleteById(id);
    }

    public Set<Category> getCategoriesByServiceId(Long Id){
        return serviceRepo.findById(Id).orElse(null).getCategories();
    }


    public List<org.example.book.dalti_back.entity.Service> findServicesSpecName(String servName){
        ServiceSpec spec = new ServiceSpec(servName);
        return serviceRepo.findAll(spec);
    }

}
