package com.myproject.controle_despesas.repository;

import com.myproject.controle_despesas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean saveCategoria(Categoria categoria);

    void deleteCategoria(Categoria categoria);
}
