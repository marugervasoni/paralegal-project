package com.api.paralegal.repository;

import com.api.paralegal.model.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordatorioRepository extends JpaRepository<Recordatorio, Long> {
}
