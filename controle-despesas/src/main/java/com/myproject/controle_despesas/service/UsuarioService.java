package com.myproject.controle_despesas.service;

import com.myproject.controle_despesas.model.Despesa;
import com.myproject.controle_despesas.model.Usuario;
import com.myproject.controle_despesas.repository.UsuarioRepository;
import com.myproject.controle_despesas.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        if(usuario.getEmail() != null && usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado!");
        }

            return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    //CRIAR VERIFICAÇÃO DE LOGIN PARA QUE CADA USUÁRIO VISUALIZE SOMENTE SUAS PRÓPRIAS DESPESAS E CRIAR CATEGORIA REPOSITORY
}
