package com.doohong.shoesfit.shoes.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "SHOES",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"brand", "name", "size"}
                )
        }
)
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
public class Shoes {
    public void Shoes() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOES_ID")
    private Integer index;

    private String brand;

    private String name;
    private int size;
    public Shoes (String brand,String name,int size){
        this.brand = brand;
        this.name = name;
        this.size = size;
    }
}
