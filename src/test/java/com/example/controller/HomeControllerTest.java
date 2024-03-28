package com.example.controller;

import com.example.model.AccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void baseController() throws Exception {
      var result=  mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("home"));
               // .andExpect(view().name("redirect:home"));


    }

    @Test
    void homeController() {
    }

    @Test
    void createAccount() throws Exception {
        AccountDto accountDto= new AccountDto("arun", "test","pass");
        var result=  mockMvc.perform(post("/create-account")
                        .flashAttr("employee",accountDto ))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("account"))
                .andExpect(view().name("accountSummary"));

        var modelMap= result.andReturn().getModelAndView().getModel();
        AccountDto account=(AccountDto) modelMap.get("account");
        System.out.println(account);

    }
}