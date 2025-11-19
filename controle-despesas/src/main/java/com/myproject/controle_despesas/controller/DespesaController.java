package com.myproject.controle_despesas.controller;

import com.myproject.controle_despesas.model.Despesa;
import com.myproject.controle_despesas.service.DespesaService;
import com.myproject.controle_despesas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Despesa> listarDespesasPorUsuarioDeUmaCategoria(Long usuarioId, String categoriaNome) {
        return usuarioService.listarDespesasPorUsuarioDeUmaCategoria(usuarioId, categoriaNome);
    }

    public List<Despesa> listarDespesasPorUsuario(String email){
        return usuarioService.listarDespesasPorUsuario(email);
    }

    @PostMapping
    public Despesa criar(@RequestBody Despesa despesa) {
        return despesaService.salvarDespesa(despesa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        despesaService.deletarDespesa(id);
    }
}