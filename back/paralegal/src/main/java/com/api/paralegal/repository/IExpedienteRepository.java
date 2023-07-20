package com.api.paralegal.repository;

import com.api.paralegal.model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpedienteRepository  extends JpaRepository<Expediente, Long> {
}
