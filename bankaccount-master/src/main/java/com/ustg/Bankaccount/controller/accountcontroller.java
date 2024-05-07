package com.ustg.Bankaccount.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.Bankaccount.exception.Accountalreadyexists;
import com.ustg.Bankaccount.exception.Accountidnotfound;
import com.ustg.Bankaccount.model.Account;
import com.ustg.Bankaccount.services.Accountservice;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class accountcontroller {
	@Autowired
	Accountservice actservice;
	@GetMapping("/viewall")
	public ResponseEntity<?> getaccount()
	{
	List<Account> actorlist=actservice.viewaccount();
	return new ResponseEntity<List>(actorlist,HttpStatus.OK);
	}
	
	@PostMapping("/addacount")
	public ResponseEntity<?> addacct(@RequestBody Account accntobj)
	{
	try {
		Account actresult=actservice.addacct(accntobj);
		
		return new ResponseEntity<Account> (actresult,HttpStatus.CREATED);
	} 
	catch (Accountalreadyexists e) {
	
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	}
	
	}

	@DeleteMapping("/delete/{acntid}")
	public ResponseEntity<?> deletemovie(@PathVariable("acntid") String accntid)
	{
		try
		{
		boolean result=	actservice.deleteaccount(accntid);
		return new ResponseEntity<String>("Account deleted successfully",HttpStatus.OK);
		}
		
		catch(Accountidnotfound e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateaccount")
	public ResponseEntity<?> updateuser(@RequestBody Account accntupdate)
	{
		Account custresult=actservice.updatecustomer(accntupdate);
		
		if(custresult==null)
			return new ResponseEntity<String>("Update failed",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>("updated ",HttpStatus.OK);
		
	}

	@GetMapping("/byid/{actid}")
	public ResponseEntity<?> getactor(@PathVariable("actid") String aname)
	{
		Optional<Account> actresult=actservice.findByAccountid(aname);
		return new ResponseEntity<Optional>(actresult,HttpStatus.OK);
	}
	
@GetMapping("/viewbymailid/{emailid}")
public ResponseEntity<?> getbyemail(@PathVariable("emailid") String emailid)
{
	List<Account> actresult=actservice.getUserByEmailid(emailid);
	return new ResponseEntity<List>(actresult,HttpStatus.OK);
}
}
