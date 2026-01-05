package com.example.banco_api.repository;

import com.example.banco_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Optional<Consulta> findConsultaByID(Long ID);

    List<Consulta> ID(Long id);

    Long ID(Long id);
}