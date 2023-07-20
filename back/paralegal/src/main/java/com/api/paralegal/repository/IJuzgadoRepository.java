package com.api.paralegal.repository;

import com.api.paralegal.model.Juzgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJuzgadoRepository  extends JpaRepository<Juzgado, Long> {
}
