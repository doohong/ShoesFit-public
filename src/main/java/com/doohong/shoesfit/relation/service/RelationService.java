package com.doohong.shoesfit.relation.service;

import com.doohong.shoesfit.relation.RelationRepository;
import com.doohong.shoesfit.relation.domain.Relation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RelationService {
    private RelationRepository relationRepository;

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
