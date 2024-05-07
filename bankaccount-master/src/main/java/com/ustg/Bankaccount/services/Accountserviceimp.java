package com.ustg.Bankaccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.Bankaccount.exception.Accountalreadyexists;
import com.ustg.Bankaccount.exception.Accountidnotfound;
import com.ustg.Bankaccount.model.Account;
import com.ustg.Bankaccount.repository.Accountrepo;

@Service
public class Accountserviceimp implements Accountservice {
	@Autowired
	Accountrepo accntrepo;

	@Override
	public Account addacct(Account accobj) throws Accountalreadyexists {
		Optional<Account> accntobj=accntrepo.findById(accobj.getAccountid());
		if(accntobj.isPresent())
			throw new Accountalreadyexists("Accountid already exists");
		else
			accntrepo.save(accobj);
		return accobj;
	}

	@Override
	public List<Account> viewaccount() {
		return accntrepo.findAll();
	}

	

	@Override
	public boolean deleteaccount(String acctid) throws Accountidnotfound {
		Optional <Account> accnt=accntrepo.findById(acctid);
		if(accnt.isPresent())
		{
			accntrepo.deleteById(acctid);
			return true;
		}
		else {
			throw new  Accountidnotfound("Inavlid id,kindly check id");
		}
	}

	@Override
	public Account updatecustomer(Account accobj) {
		Optional<Account> accres=accntrepo.findById(accobj.getAccountid());
		if(accres.isPresent())
		{
			accntrepo.save(accobj);
			return accobj;
		}
		else
			return null;
	}

	@Override
	public Optional<Account> findByAccountid(String id) {
		Optional<Account> accntobj=accntrepo.findById(id);
		return accntobj;
	}

	@Override
	public List<Account> getUserByEmailid(String emailid) {
		List<Account> accnt=accntrepo.findByEmailid(emailid);
		return accnt;
	}

}
