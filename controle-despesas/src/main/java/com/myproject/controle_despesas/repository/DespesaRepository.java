package com.myproject.controle_despesas.repository;

import com.myproject.controle_despesas.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    //lista todas as despesas do usuário, usando email
    List<Despesa> findAllByUsuario_EmailEquals(String email);

    //lista todas as depsesas do usuário com determinada categoria
    List<Despesa> findAllByUsuarioIdECategoriaNome(Long usuarioId, String tipo);


}
