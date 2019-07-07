package com.doohong.shoesfit.relation.domain;

import com.doohong.shoesfit.shoes.domain.Shoes;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_r_shoes",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"shoes1_no", "shoes2_no"}
                )
        }
)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_shoes_no")
    private Integer index;

    @ManyToOne
    @JoinColumnsOrFormulas(value = {
            @JoinColumnOrFormula(column =
            @JoinColumn(name = "shoes1_no",
                    referencedColumnName = "shoes_no")),
    })
    private Shoes shoes1;

    @ManyToOne
    @JoinColumnsOrFormulas(value = {
            @JoinColumnOrFormula(column =
            @JoinColumn(name = "shoes2_no",
                    referencedColumnName = "shoes_no")),
    })
    private Shoes shoes2;

    @Column(name = "r_shoes_count", columnDefinition = "INT default 1")
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

