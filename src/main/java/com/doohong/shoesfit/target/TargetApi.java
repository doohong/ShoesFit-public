package com.doohong.shoesfit.target;

import com.doohong.shoesfit.target.dto.TargetRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TargetApi {
    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody @Valid TargetRequest dto){
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
