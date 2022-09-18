package com.easd.controlevendas.repository;


import com.easd.controlevendas.model.Cidade;
import com.easd.controlevendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
