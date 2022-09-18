package com.easd.controlevendas.repository;

import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
