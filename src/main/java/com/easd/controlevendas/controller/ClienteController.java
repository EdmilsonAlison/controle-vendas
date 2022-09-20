package com.easd.controlevendas.controller;

import com.easd.controlevendas.dto.CategoriaDto;
import com.easd.controlevendas.dto.ClienteDto;
import com.easd.controlevendas.service.CategoriaService;
import com.easd.controlevendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listar(){
        List<ClienteDto> clienteDtos = clienteService.listarTodasCategorias();
        return new ResponseEntity<>(clienteDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteDto>> buscarCategoriaPorId(@PathVariable Integer id){
        Optional<ClienteDto> clienteDto = clienteService.buscarCategoriaPorId(id);
        return new ResponseEntity<>(clienteDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> adicionar(@RequestBody ClienteDto clienteDto){
        clienteService.adicionar(clienteDto);
        return new ResponseEntity<>(clienteDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        clienteService.deletar(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(@PathVariable Integer id, @RequestBody ClienteDto clienteDto){
        ClienteDto cliDto = clienteService.atualizar(id, clienteDto);
        return new ResponseEntity<>(cliDto,HttpStatus.OK);
    }





}
