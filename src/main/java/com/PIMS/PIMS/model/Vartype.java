package com.PIMS.PIMS.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
public class Vartype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @Column
    String name;
    @Column
    String siginificado;
    @Column
    String obesavacao;

    public Vartype(){
        super();
    }

}
