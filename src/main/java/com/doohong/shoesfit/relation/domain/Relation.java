package com.doohong.shoesfit.relation.domain;

import com.doohong.shoesfit.shoes.domain.Shoes;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import javax.persistence.*;

@Entity
@Table(
        name = "RELATION",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"SHOES1_ID", "SHOES2_ID"}
                )
        }
)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RELATION_ID")
    private Integer index;

    @ManyToOne
    @JoinColumnsOrFormulas(value = {
            @JoinColumnOrFormula(column =
            @JoinColumn(name = "SHOES1_ID",
                    referencedColumnName = "SHOES_ID")),
    })
    private Shoes shoes1;

    @ManyToOne
    @JoinColumnsOrFormulas(value = {
            @JoinColumnOrFormula(column =
            @JoinColumn(name = "SHOES2_ID",
                    referencedColumnName = "SHOES_ID")),
    })
    private Shoes shoes2;

    @Column(columnDefinition = "INT default 1")
    private int count;

    public Relation(Shoes shoes1,Shoes shoes2){
        this.shoes1 = shoes1;
        this.shoes2 = shoes2;
        this.count = 1;
    }
    public void addCount(){
        this.count ++;
    }
}

