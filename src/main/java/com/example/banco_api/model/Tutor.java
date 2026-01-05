package com.example.banco_api.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Tutor extends  Pessoa {

    public Tutor(){

    }
    @OneToMany(mappedBy = "tutor")
    private List<Animal> animais;

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
}
