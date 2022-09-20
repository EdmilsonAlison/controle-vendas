package com.easd.controlevendas.service;

import com.easd.controlevendas.dto.CategoriaDto;
import com.easd.controlevendas.handler.exceptions.DeleteClassException;
import com.easd.controlevendas.handler.exceptions.NotFoundException;
import com.easd.controlevendas.model.Categoria;
import com.easd.controlevendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository catRepo;

    public List<CategoriaDto> listarTodasCategorias(){
        List<Categoria> categoriaList = catRepo.findAll();
        return categoriaList.stream().map(categoria -> new ModelMapper().map(categoria, CategoriaDto.class))
                .collect(Collectors.toList());
    }

    public Optional<CategoriaDto> buscarCategoriaPorId(Integer id){
        Optional<Categoria> categoria = catRepo.findById(id);
        if(categoria.isEmpty()){
            throw new NotFoundException("Categorie not found");
        }
        CategoriaDto categoriaDto = new ModelMapper().map(categoria.get(), CategoriaDto.class);
        return Optional.of(categoriaDto);
    }

    public CategoriaDto adicionar(CategoriaDto categoriaDto){
        Categoria categoria = new ModelMapper().map(categoriaDto, Categoria.class);
        categoria = catRepo.save(categoria);
        return  categoriaDto;
    }

    public void deletar( Integer id){
        Optional<Categoria> categoria = catRepo.findById(id);
        if (categoria.isEmpty()){
            throw  new NotFoundException("Categorie not found");
        }
        if(categoria.get().getProdutos() != null){
            throw  new DeleteClassException("Categoria possuí produtos registrados");
        }
            catRepo.deleteById(id);

    }


    public CategoriaDto atualizar(Integer id, CategoriaDto catDto){
        catDto.setId(id);
        Categoria categoria = new ModelMapper().map(catDto, Categoria.class);
        categoria = catRepo.save(categoria);
        categoria.setId(catDto.getId());
        return catDto;
    }


}
