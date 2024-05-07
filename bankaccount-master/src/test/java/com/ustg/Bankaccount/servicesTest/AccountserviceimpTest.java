package com.ustg.Bankaccount.servicesTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ustg.Bankaccount.exception.Accountalreadyexists;
import com.ustg.Bankaccount.exception.Accountidnotfound;
import com.ustg.Bankaccount.model.Account;
import com.ustg.Bankaccount.repository.Accountrepo;
import com.ustg.Bankaccount.services.Accountserviceimp;

public class AccountserviceimpTest {
	 @Mock
	   Accountrepo repo;

	   Account account;

	    @InjectMocks
	    Accountserviceimp service;

	    List<Account> userList ;
	    Optional<Account> options;
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);

	       account = new Account();
	       account.setEmailid("nayanaksr");
	 	   account.setBankname("canara");
	 	    account.setBankcode("236");
	 	    account.setBankbranch("peenya");
	 	    account.setAddress("bangalore");
	 	    account.setAccounttype("savings");
	 	    account.setAccountid("2368");
	 	    account.setAadhar("56233");
	        userList = new ArrayList<>();
	        userList.add(account);

	        options = Optional.of(account);

	    }
	    @Test
	    public void addaccountSuccess() throws Accountalreadyexists {
	        when(repo.insert(account)).thenReturn(account);
	        Account userSaved = service.addacct(account);
	        assertEquals(account, userSaved);

	    }
	   

	    @Test
	    public void updateUser()  {
	        when(repo.findById(account.getAccountid())).thenReturn(options);
	        account.setBankname("sbi");
	        Account fetchuser = service.updatecustomer(account);
	        assertEquals(account, fetchuser);

	    }

	    @Test
	    public void deleteUserSuccess() throws Accountidnotfound {
	        when(repo.findById(account.getAccountid())).thenReturn(options);
	        boolean flag = service.deleteaccount(account.getAccountid());
	        assertEquals(true, flag);

	    }
	    
//	    @Test
//	    public void getUserById()  {
//	        when(repo.findById(account.getAccountid())).thenReturn(options);
//	        List<Account> fetchedUser = service.findByAccountid(account.getAccountid());
//	        assertEquals(account, fetchedUser);
//	    }

}
