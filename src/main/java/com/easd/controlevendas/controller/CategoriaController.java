package com.easd.controlevendas.controller;

import com.easd.controlevendas.dto.CategoriaDto;
import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/page")
    public ResponseEntity<Page<CategoriaDto>> listarPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                         @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
                                                         @RequestParam(value = "orderBy", defaultValue = "nome")String orderBy,
                                                         @RequestParam(value = "direction", defaultValue = "ASC")String direction ){
        Page<Categoria> categoria = catService.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoriaDto> pageDto = categoria.map(cat -> new CategoriaDto(cat));
        return new ResponseEntity<>(pageDto, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaDto>> buscarCategoriaPorId(@PathVariable Integer id){
        Optional<CategoriaDto> optionalCategoriaDto = catService.buscarCategoriaPorId(id);
        return new ResponseEntity<>(optionalCategoriaDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> adicionar(@Valid @RequestBody CategoriaDto categoriaDto){
        catService.adicionar(categoriaDto);
        return new ResponseEntity<>(categoriaDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        catService.deletar(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Integer id, @Valid @RequestBody CategoriaDto catDto){
        CategoriaDto categoriaDto = catService.atualizar(id, catDto);
        return new ResponseEntity<>(categoriaDto,HttpStatus.OK);
    }





}
