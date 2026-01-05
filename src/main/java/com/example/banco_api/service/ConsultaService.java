package com.example.banco_api.service;

import com.example.banco_api.model.Consulta;
import com.example.banco_api.model.Veterinario;
import com.example.banco_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.banco_api.dto.ConsultaDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public Consulta agendarConsulta(ConsultaDTO dados) {
        Consulta consulta = new Consulta();
        consulta.setAnimal(dados.animal());
        consulta.setData(dados.data());
        consulta.setVeterinario(dados.CRMV());
        validarConsulta(consulta);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta.getAnimal(), consulta.getData(), consulta.getVeterinario());
        UUID codigo = UUID.randomUUID();
        String codigoFormatado = codigo.toString();
        consulta.setProtocolo(codigoFormatado);
        consulta.setAnimal(ConsultaDTO);
        return repository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return repository.findAll();
    }

    public void removerConsulta(Long ID) {
        repository.deleteById(ID);
    }

    public Consulta editarConsulta(Consulta consulta) {
        validarConsulta(consulta);
        if (repository.existsById(consulta.getID())) {
            return repository.save(consulta);
        }
        return null;
    }

    private void validarConsulta(Consulta consulta){

        LocalDateTime compararData = consulta.getData();

        if (compararData.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Erro: Você não pode agendar uma consulta antes da data atual.");
        }
        else if (compararData.getHour() < 7 || compararData.getHour() > 17){
            throw new IllegalArgumentException("Erro: horário de funcionamento da clínica 07:00 - 17:00");
        }
    }
}
