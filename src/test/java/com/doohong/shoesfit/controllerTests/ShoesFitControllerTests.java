package com.doohong.shoesfit.controllerTests;


import com.doohong.shoesfit.target.dto.ShoesDTO;
import com.doohong.shoesfit.target.dto.TargetDTO;
import com.doohong.shoesfit.target.dto.TargetRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoesFitControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void test() throws Exception {
        ShoesDTO shoesDTO1 = new ShoesDTO("나이키","코르테즈",265);
        ShoesDTO shoesDTO2 = new ShoesDTO("컨버스","척테일러",260);
        TargetDTO target = new TargetDTO("아디다스","슈퍼스타");
        List<ShoesDTO> shoesList = new ArrayList<>();
        shoesList.add(shoesDTO1);
        shoesList.add(shoesDTO2);
        TargetRequest targetRequest = new TargetRequest(shoesList,target);


        mockMvc.perform(post("/events/target")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(targetRequest)))
                .andDo(print());
    }

}
