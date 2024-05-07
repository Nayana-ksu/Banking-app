package com.ustg.Bankaccount.repositoryTest;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ustg.Bankaccount.exception.Accountidnotfound;
import com.ustg.Bankaccount.model.Account;
import com.ustg.Bankaccount.repository.Accountrepo;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountrepoTest {
	 @Autowired
	    private Accountrepo repo;
	    private Account account;
	    @Before
	    public void setUp() throws Exception {
	        account = new Account();
	        account.setEmailid("nayanaksr");
	 	   account.setBankname("canara");
	 	    account.setBankcode("236");
	 	    account.setBankbranch("peenya");
	 	    account.setAddress("bangalore");
	 	    account.setAccounttype("savings");
	 	    account.setAccountid("236");
	 	    account.setAadhar("56233");
	    }
	    @After
	    public void tearDown() throws Exception {
	    	repo.deleteAll();
	    }


 @Test
 public void accountaddTest() {
	 repo.insert(account);
	 Account adduser = repo.findById("236").get();
	 assertEquals(account.getAccountid(), adduser.getAccountid());
 }
 
 @Test
 public void deleteaccountTest() {
 	repo.insert(account);
	Account fetcheduser = repo.findById("236").get();
     assertEquals("236", fetcheduser.getAccountid());
     repo.delete(fetcheduser);
     try {
     	repo.findById("236").get();
     }catch(Exception exception) {
    	assertEquals(NoSuchElementException.class, exception.getClass());
    }

 }

 
 @Test
 public void getUserByIdTest() {
 	repo.insert(account);
 	Account fetcheduser = repo.findById("236").get();
     assertEquals(account.getAccountid(),fetcheduser.getAccountid());

 }


}
