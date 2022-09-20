package com.easd.controlevendas.controller;

import com.easd.controlevendas.dto.ClienteDto;
import com.easd.controlevendas.dto.PedidoDto;
import com.easd.controlevendas.service.ClienteService;
import com.easd.controlevendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listar(){
        List<PedidoDto> pedidoDtos = pedidoService.listarTodosPedidos();
        return new ResponseEntity<>(pedidoDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoDto>> buscarPedidoPorId(@PathVariable Integer id){
        Optional<PedidoDto> pedidoDto = pedidoService.buscarPedidoPorId(id);
        return new ResponseEntity<>(pedidoDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> adicionar(@RequestBody PedidoDto pedidoDto){
        pedidoService.adicionar(pedidoDto);
        return new ResponseEntity<>(pedidoDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        pedidoService.deletar(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Integer id, @RequestBody PedidoDto pedidoDto){
        PedidoDto pedDto = pedidoService.atualizar(id, pedidoDto);
        return new ResponseEntity<>(pedDto,HttpStatus.OK);
    }





}
