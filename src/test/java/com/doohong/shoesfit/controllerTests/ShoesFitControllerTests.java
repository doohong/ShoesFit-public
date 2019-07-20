package com.doohong.shoesfit.controllerTests;


import com.doohong.shoesfit.member.MemberRepository;
import com.doohong.shoesfit.member.domain.MemberRole;
import com.doohong.shoesfit.member.dto.LoginMemberDTO;
import com.doohong.shoesfit.member.dto.MemberDTO;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoesFitControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void find_Target_Right_Value() throws Exception {
        ShoesDTO shoesDTO1 = new ShoesDTO("나이키", "코르테즈", 265);
        ShoesDTO shoesDTO2 = new ShoesDTO("컨버스", "척테일러", 260);
        TargetDTO target = new TargetDTO("아디다스", "슈퍼스타");
        List<ShoesDTO> shoesList = new ArrayList<>();
        shoesList.add(shoesDTO1);
        shoesList.add(shoesDTO2);
        TargetRequest targetRequest = new TargetRequest(shoesList, target);


        mockMvc.perform(post("/events/target")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(targetRequest)))
                .andDo(print())
                .andExpect(status().isOk())

        ;
    }

    @Test
    public void find_Target_Same_Value() throws Exception {
        ShoesDTO shoesDTO1 = new ShoesDTO("나이키", "코르테즈", 265);
        ShoesDTO shoesDTO2 = new ShoesDTO("나이키", "코르테즈", 260);
        TargetDTO target = new TargetDTO("아디다스", "슈퍼스타");
        List<ShoesDTO> shoesList = new ArrayList<>();
        shoesList.add(shoesDTO1);
        shoesList.add(shoesDTO2);
        TargetRequest targetRequest = new TargetRequest(shoesList, target);


        mockMvc.perform(post("/events/target")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(targetRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("SS_001"))

        ;
    }

    @Test
    public void find_Target_Same_Target() throws Exception {
        ShoesDTO shoesDTO1 = new ShoesDTO("나이키", "코르테즈", 265);
        ShoesDTO shoesDTO2 = new ShoesDTO("아디다스", "슈퍼스타", 260);
        TargetDTO target = new TargetDTO("나이키", "코르테즈");
        List<ShoesDTO> shoesList = new ArrayList<>();
        shoesList.add(shoesDTO1);
        shoesList.add(shoesDTO2);
        TargetRequest targetRequest = new TargetRequest(shoesList, target);


        mockMvc.perform(post("/events/target")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(targetRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value("TN_001"))

        ;
    }

    @Test
    public void get_List() throws Exception {


        mockMvc.perform(post("/events/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{}"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void registration() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder().email("wnghd94@gmail.com").password("123").name("박주홍").build();
        mockMvc.perform(post("/api/member/registration")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(memberDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void login_not_found_user() throws Exception {
        LoginMemberDTO loginMemberDTO = LoginMemberDTO.builder().username("wnghd95@naver.com").password("123").build();
        mockMvc.perform(post("/api/member/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(loginMemberDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
    @Test
    public void login_success() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder().email("wnghd95@naver.com").password("123").name("박주홍").build();
        mockMvc.perform(post("/api/member/registration")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(memberDTO)))
                .andDo(print());

        LoginMemberDTO loginMemberDTO = LoginMemberDTO.builder().username("wnghd95@naver.com").password("123").build();
        mockMvc.perform(post("/api/member/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(loginMemberDTO)))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void login_differ_password() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder().email("wnghd95@naver.com").password("123").name("박주홍").build();
        mockMvc.perform(post("/api/member/registration")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(memberDTO)))
                .andDo(print());

        LoginMemberDTO loginMemberDTO = LoginMemberDTO.builder().username("wnghd95@naver.com").password("1234").build();
        mockMvc.perform(post("/api/member/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(loginMemberDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
}
