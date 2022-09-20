package com.easd.controlevendas.service;

import com.easd.controlevendas.dto.ClienteDto;
import com.easd.controlevendas.dto.PedidoDto;
import com.easd.controlevendas.handler.exceptions.NotFoundException;
import com.easd.controlevendas.model.Cliente;
import com.easd.controlevendas.model.Pedido;
import com.easd.controlevendas.repository.ClienteRepository;
import com.easd.controlevendas.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDto> listarTodosPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(cliente -> new ModelMapper().map(pedidos, PedidoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<PedidoDto> buscarPedidoPorId(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isEmpty()){
            throw new NotFoundException("Pedido not found");
        }
        PedidoDto pedidoDto = new ModelMapper().map(pedido.get(), PedidoDto.class);
        return Optional.of(pedidoDto);
    }

    public PedidoDto adicionar(PedidoDto pedidoDto){
        Pedido pedido = new ModelMapper().map(pedidoDto, Pedido.class);
        pedido = pedidoRepository.save(pedido);
        return  pedidoDto;
    }

    public void deletar( Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()){
            throw  new NotFoundException("Pedido not found");
        }
        pedidoRepository.deleteById(id);
    }


    public PedidoDto atualizar(Integer id, PedidoDto pedidoDto){

        if(pedidoRepository.existsById(pedidoDto.getId())){
            Pedido pedido = new ModelMapper().map(pedidoDto, Pedido.class);
            pedido = pedidoRepository.save(pedido);
            return pedidoDto;
        }
        throw new NotFoundException("Pedido não existe");
    }


}
