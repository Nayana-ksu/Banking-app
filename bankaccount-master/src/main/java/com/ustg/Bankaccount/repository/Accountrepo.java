package com.ustg.Bankaccount.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ustg.Bankaccount.model.Account;

public interface Accountrepo  extends MongoRepository<Account,String> {
	List<Account> findByEmailid(String emailid);
}
