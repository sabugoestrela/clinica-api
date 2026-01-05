package com.example.banco_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true)
    private String protocolo;

    @Column(nullable = false)
    private LocalDateTime data;
    @Column(nullable = false)
    private String motivo;
    @Column(nullable = false)
    private String status;

    @JoinColumn (name = "animal")
    @ManyToOne
    Animal animal;

    @JoinColumn (name = "veterinario")
    @ManyToOne
    Veterinario veterinario;

    public Consulta(){

    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
