package com.myproject.controle_despesas.service;

import com.myproject.controle_despesas.model.Categoria;
import com.myproject.controle_despesas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Categoria categoria){
        categoriaRepository.deleteCategoria(categoria);
    }
}
