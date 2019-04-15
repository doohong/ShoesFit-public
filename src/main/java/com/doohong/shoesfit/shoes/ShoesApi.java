package com.doohong.shoesfit.shoes;

import com.doohong.shoesfit.shoes.dto.ShoesResponse;
import com.doohong.shoesfit.shoes.service.ShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoesApi {
    private ShoesService shoesService;

    @PostMapping("/list")
    public ResponseEntity<ShoesResponse> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(shoesService.getShoesList());
    }
}
