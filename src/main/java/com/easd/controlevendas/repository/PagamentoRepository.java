package com.easd.controlevendas.repository;

import com.easd.controlevendas.model.Pagamento;
import com.easd.controlevendas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
