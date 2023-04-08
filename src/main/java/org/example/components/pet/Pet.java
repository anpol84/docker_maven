package org.example.components.pet;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kind;
    private double weight;
    private String alias;
    private String gender;
    private String color;
    private double price;
}
