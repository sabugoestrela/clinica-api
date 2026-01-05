package com.example.banco_api.dto;

import com.example.banco_api.model.Animal;

import java.time.LocalDateTime;

public record ConsultaDTO(Animal animal, LocalDateTime data, String CRMV) {

}
