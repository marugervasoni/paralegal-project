package com.api.paralegal.repository;

import com.api.paralegal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository  extends JpaRepository<Cliente, Long> {
}
