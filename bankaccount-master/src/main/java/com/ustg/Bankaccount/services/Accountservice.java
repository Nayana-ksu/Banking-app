package com.ustg.Bankaccount.services;

import java.util.List;
import java.util.Optional;

import com.ustg.Bankaccount.exception.Accountalreadyexists;
import com.ustg.Bankaccount.exception.Accountidnotfound;
import com.ustg.Bankaccount.model.Account;

public interface Accountservice {
Account addacct(Account accobj) throws Accountalreadyexists;
List<Account> viewaccount();
boolean deleteaccount(String acctid) throws Accountidnotfound;
Account updatecustomer(Account accobj);
Optional<Account> findByAccountid(String id);
List<Account> getUserByEmailid(String emailid) ;
}
