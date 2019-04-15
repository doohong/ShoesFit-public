package com.doohong.shoesfit.target.service;

import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.relation.service.RelationSaveService;
import com.doohong.shoesfit.shoes.domain.Shoes;
import com.doohong.shoesfit.shoes.service.ShoesSaveService;
import com.doohong.shoesfit.target.dto.TargetRequest;
import com.doohong.shoesfit.target.dto.TargetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TargetService {
    private ShoesSaveService shoesSaveService;
    private RelationSaveService relationSaveService;

//    public TargetResponse targetFind(TargetRequest dto){
//        List<Shoes> shoesList = shoesSaveService.shoesSave(dto.getShoesList());
//        List<Relation> relationList;
//        if(shoesList.size()>1){
//            relationList=relationSaveService.relationSave(shoesList);
//        }
//        return new TargetResponse();
//    }
}
