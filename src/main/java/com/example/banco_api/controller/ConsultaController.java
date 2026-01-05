package com.example.banco_api.controller;

import com.example.banco_api.model.Consulta;
import com.example.banco_api.repository.ConsultaRepository;
import com.example.banco_api.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")

public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public Consulta receberPedidosDoSite(@RequestBody Consulta dadosDaConsulta){
        return service.agendarConsulta(dadosDaConsulta);
    }
    @GetMapping
    public List<Consulta> verificarConsultas(){
        return service.listarConsultas();
    }
    @PutMapping
    public Consulta editarConsulta(@RequestBody Consulta dadosDaConsulta){
        return service.editarConsulta(dadosDaConsulta);
    }
    @DeleteMapping("/{id}")
    public void removerConsultas(@PathVariable Long id){
        service.removerConsulta(id);
    }

}

