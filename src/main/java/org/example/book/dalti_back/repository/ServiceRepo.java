package org.example.book.dalti_back.repository;

import org.example.book.dalti_back.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ServiceRepo extends JpaRepository<Service, Long> , JpaSpecificationExecutor<Service> {

}
