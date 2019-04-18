package com.doohong.shoesfit.relation.service;

import com.doohong.shoesfit.relation.RelationRepository;
import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.shoes.domain.Shoes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationSaveService {
    private RelationRepository relationRepository;
    public List<Relation> relationSave(List<Shoes> shoesList){
        List<Relation> relationList = new ArrayList<>();
        for(Shoes shoes1 : shoesList){
            for(Shoes shoes2 : shoesList){
                if(shoes1.getIndex()<shoes2.getIndex()){
                    Relation relation = relationRepository.findByShoes1AndShoes2(shoes1,shoes2);
                    if(relation!=null){
                        relation.addCount();
                    }
                    else{
                        relation = new Relation(shoes1,shoes2);
                    }
                    relationList.add(relationRepository.save(relation));
                }
            }
        }
        return relationList;

    }
    public int[][] getRelationArray(int size){
        List<Relation> relationList = relationRepository.findAll();
        int[][] relationArray = new int[size + 1][size + 1];
        for (Relation relation : relationList) {
            relationArray[relation.getShoes1().getIndex().intValue()][relation.getShoes2().getIndex().intValue()] = relation.getCount();
            relationArray[relation.getShoes2().getIndex().intValue()][relation.getShoes1().getIndex().intValue()] = relation.getCount();
        }
        return relationArray;
    }
}
