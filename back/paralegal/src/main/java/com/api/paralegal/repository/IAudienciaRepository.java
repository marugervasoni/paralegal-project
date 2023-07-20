package com.api.paralegal.repository;

import com.api.paralegal.model.Audiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAudienciaRepository  extends JpaRepository<Audiencia, Long> {
}
