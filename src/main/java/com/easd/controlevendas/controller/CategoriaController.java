package com.easd.controlevendas.controller;

import com.easd.controlevendas.dto.CategoriaDto;
import com.easd.controlevendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService catService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listar(){
        List<CategoriaDto> categoriaDto = catService.listarTodasCategorias();
        return new ResponseEntity<>(categoriaDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaDto>> buscarCategoriaPorId(@PathVariable Integer id){
        Optional<CategoriaDto> optionalCategoriaDto = catService.buscarCategoriaPorId(id);
        return new ResponseEntity<>(optionalCategoriaDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> adicionar(@RequestBody CategoriaDto categoriaDto){
        catService.adicionar(categoriaDto);
        return new ResponseEntity<>(categoriaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        catService.deletar(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Integer id, @RequestBody CategoriaDto catDto){
        CategoriaDto categoriaDto = catService.atualizar(id, catDto);
        return new ResponseEntity<>(categoriaDto,HttpStatus.OK);
    }





}
