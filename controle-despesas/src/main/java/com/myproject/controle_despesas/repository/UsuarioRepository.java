package com.myproject.controle_despesas.repository;

import com.myproject.controle_despesas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    //optional serve para evitar o erro NullPointerException. Ele encapsula o resultado da busca
    //indicando explicitamente se um usuário foi encontrado ou não

    boolean existsByEmail(String email);

}
