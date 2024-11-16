package com.ada.prueba.domain.repository;

import com.ada.prueba.domain.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
