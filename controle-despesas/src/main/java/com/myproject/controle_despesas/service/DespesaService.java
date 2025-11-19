package com.myproject.controle_despesas.service;

import com.myproject.controle_despesas.model.Despesa;
import com.myproject.controle_despesas.model.Usuario;
import com.myproject.controle_despesas.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvarDespesa(Despesa despesa){
        return despesaRepository.save(despesa);
    }

    public void deletarDespesa(Long id){
        despesaRepository.deleteDespesa(id);
    }


}
