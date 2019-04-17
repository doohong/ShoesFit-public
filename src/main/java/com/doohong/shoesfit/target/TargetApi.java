package com.doohong.shoesfit.target;

import com.doohong.shoesfit.target.dto.TargetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
public class TargetApi {
    @PostMapping("/test")
    public String test(@Valid @RequestBody TargetRequest dto){

        return "j";
    }
}
