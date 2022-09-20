package com.easd.controlevendas.service;

import com.easd.controlevendas.dto.CategoriaDto;
import com.easd.controlevendas.dto.ClienteDto;
import com.easd.controlevendas.handler.exceptions.NotFoundException;
import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.model.Cliente;
import com.easd.controlevendas.repository.CategoriaRepository;
import com.easd.controlevendas.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> listarTodasCategorias(){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ClienteDto> buscarCategoriaPorId(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new NotFoundException("Cliente not found");
        }
        ClienteDto clienteDto = new ModelMapper().map(cliente.get(), ClienteDto.class);
        return Optional.of(clienteDto);
    }

    public ClienteDto adicionar(ClienteDto clienteDto){
        Cliente cliente = new ModelMapper().map(clienteDto, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return  clienteDto;
    }

    public void deletar( Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw  new NotFoundException("Categorie not found");
        }
        clienteRepository.deleteById(id);
    }


    public ClienteDto atualizar(Integer id, ClienteDto clienteDto){

        if(clienteRepository.existsById(clienteDto.getId())){
            Cliente cliente = new ModelMapper().map(clienteDto, Cliente.class);
            cliente = clienteRepository.save(cliente);
            return clienteDto;
        }
        throw new NotFoundException("Cliente não existe");
    }


}
