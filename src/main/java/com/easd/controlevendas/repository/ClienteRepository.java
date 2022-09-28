package com.easd.controlevendas.repository;

import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    public Cliente findByEmail(String email);


}
