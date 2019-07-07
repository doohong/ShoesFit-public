package com.doohong.shoesfit.shoes.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_shoes",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"shoes_brand", "shoes_name", "shoes_size"}
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
    @Column(name = "shoes_no")
    private Integer index;

    @Column(name = "shoes_brand")
    private String brand;

    @Column(name = "shoes_name")
    private String name;
    @Column(name = "shoes_size")
    private int size;

    public Shoes (String brand,String name,int size){
        this.brand = brand;
        this.name = name;
        this.size = size;
    }
}
