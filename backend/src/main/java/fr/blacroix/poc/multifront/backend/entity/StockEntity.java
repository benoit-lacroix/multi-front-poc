package fr.blacroix.poc.multifront.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;
    private String color;
}
