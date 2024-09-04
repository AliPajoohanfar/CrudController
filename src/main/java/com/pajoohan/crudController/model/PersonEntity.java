package com.pajoohan.crudController.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Component
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateGen")
    @SequenceGenerator(name = "hibernateGen", sequenceName = "HIBERNATE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FAMILY")
    private String family;
    
    @Column(name = "NATIONAL_CODE")
    private String nationalCode;
}
