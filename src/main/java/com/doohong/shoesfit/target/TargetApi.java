package com.doohong.shoesfit.target;

import com.doohong.shoesfit.shoes.ShoesRepository;
import com.doohong.shoesfit.target.dto.TargetRequest;
import com.doohong.shoesfit.target.dto.TargetResponse;
import com.doohong.shoesfit.target.service.TargetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/events")
public class TargetApi {

    private final TargetService targetService;

    @PostMapping(value = "/target")
    public ResponseEntity findTarget(@RequestBody @Valid TargetRequest dto){

        TargetResponse targetResponse = targetService.findTarget(dto);
        return new ResponseEntity<>(targetResponse,HttpStatus.OK);
    }


}
