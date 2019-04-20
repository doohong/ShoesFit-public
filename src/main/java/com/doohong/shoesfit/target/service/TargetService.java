package com.doohong.shoesfit.target.service;

import com.doohong.shoesfit.relation.domain.Relation;
import com.doohong.shoesfit.relation.service.RelationSaveService;
import com.doohong.shoesfit.relation.service.RelationService;
import com.doohong.shoesfit.shoes.domain.Shoes;
import com.doohong.shoesfit.shoes.service.ShoesSaveService;
import com.doohong.shoesfit.shoes.service.ShoesService;
import com.doohong.shoesfit.target.dto.TargetRequest;
import com.doohong.shoesfit.target.dto.TargetResponse;
import com.doohong.shoesfit.target.exception.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.doohong.shoesfit.error.ErrorCode.TARGET_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TargetService {
    private ShoesSaveService shoesSaveService;
    private ShoesService shoesService;
    private RelationSaveService relationSaveService;
    private RelationService relationService;

    // 타켓 검색
    public TargetResponse targetFind(TargetRequest dto){
        List<Shoes> shoesList = shoesSaveService.shoesSave(dto.getShoesList());
        List<Relation> relationList = new ArrayList<>();
        List<List<int[]>> targetSizeList = new ArrayList<>();
        if(shoesList.size()>1){
            relationList=relationSaveService.relationSave(shoesList);
        }
        List<Shoes> targetList = shoesService.findTargetList(dto.getTartget());
        if(targetList.size()==0) throw new TargetNotFoundException(TARGET_NOT_FOUND);
        boolean targetCheck = false;
        for(Shoes shoes : shoesList){
            int shoesIndex=shoes.getIndex();
            int[][] relationArray = relationService.getRelationArray(shoesService.getShoesMaxIndex());
            // 가지고있는 신발을 이용해 다른 신발과의 관계 변경
            for(int i=1;i<relationArray.length;i++){
                if(relationArray[shoesIndex][i] !=0){
                    for(int j=1;j<relationArray.length;j++){
                        if(relationArray[i][j]!=0) relationArray[shoesIndex][j]=Math.max(relationArray[shoesIndex][j], Math.min(relationArray[shoesIndex][i], relationArray[i][j]));
                    }

                }
            }
            // 관계를 가지고 타겟 확인
            List<int[]> sizeCountList = new ArrayList<>();
            for(Shoes target : targetList){
                int targetIndex = target.getIndex();
                if(relationArray[shoesIndex][targetIndex]!=0){
                    targetCheck = true;
                    sizeCountList.add(new int[]{target.getSize(),relationArray[shoesIndex][targetIndex]});
                }
            }
            targetSizeList.add(sizeCountList);
        }
        if(targetCheck) throw new TargetNotFoundException(TARGET_NOT_FOUND);
        return TargetResponse.builder().shoesList(shoesList).relationList(relationList).targetDTO(dto.getTartget()).targetSizeList(targetSizeList).build();
    }
}
