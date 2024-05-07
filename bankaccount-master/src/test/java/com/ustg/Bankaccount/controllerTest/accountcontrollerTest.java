package com.ustg.Bankaccount.controllerTest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustg.Bankaccount.controller.accountcontroller;
import com.ustg.Bankaccount.model.Account;
import com.ustg.Bankaccount.services.Accountservice;
@RunWith(SpringRunner.class)
@WebMvcTest

public class accountcontrollerTest {
   @Autowired
	MockMvc mockmvc;
	
	@InjectMocks
	accountcontroller controller;
    
	@MockBean
	Accountservice uniservice;
	
Account account;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		mockmvc=MockMvcBuilders.standaloneSetup(controller).build();
	    account =new Account();
	    account.setEmailid("nayanaksr");
	   account.setBankname("canara");
	    account.setBankcode("236");
	    account.setBankbranch("peenya");
	    account.setAddress("bangalore");
	    account.setAccounttype("savings");
	    account.setAccountid("cbr236");
	    account.setAadhar("56233");
    }
	
	@Test
	public void whenaddthenstoreaccountsuccess() throws Exception
	{
	Mockito.when(uniservice.addacct(account)).thenReturn(account);
	mockmvc.perform(MockMvcRequestBuilders.post("/api/account/addacount")
										    .contentType(MediaType.APPLICATION_JSON)
											.content(convertObjToJson(account)))
											.andExpect(MockMvcResultMatchers.status().isCreated())
											.andDo(MockMvcResultHandlers.print());							
	}
	private String convertObjToJson(Object obj) throws JsonProcessingException,Exception {
		ObjectMapper objectMapper=new ObjectMapper();
		String op=objectMapper.writeValueAsString(obj);
		return op;
	}
	
	@Test
	public void testviewAllaccount() throws Exception
	{
		mockmvc.perform(MockMvcRequestBuilders.get("/api/account/viewall"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    public void updateaccountSuccess() throws Exception {
		
        when(uniservice.updatecustomer( any())).thenReturn(account);
	   account.setAadhar("2563");
        mockmvc.perform(put("/api/account/updateaccount")
                .contentType(MediaType.APPLICATION_JSON).content(convertObjToJson(account)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

	 @Test
	    public void deleteaccountSuccess() throws Exception {

	        when(uniservice.deleteaccount("canara")).thenReturn(true);
	        mockmvc.perform(MockMvcRequestBuilders.delete("/api/account/delete/cbr236")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());
	    }

   

	
}
