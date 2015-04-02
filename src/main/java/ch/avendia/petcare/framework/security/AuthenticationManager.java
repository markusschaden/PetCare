package ch.avendia.petcare.framework.security;

import ch.avendia.petcare.datastore.DataStoreService;
import ch.avendia.petcare.datastore.DatabaseManager;
import ch.avendia.petcare.entities.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Markus on 01.04.2015.
 */
public class AuthenticationManager {


    public boolean authorize(Account account) {


        DataStoreService<Account> dataStoreService = new DataStoreService<Account>();
        DatabaseManager databaseManager = dataStoreService.getDatabaseManager();

        Map map = new HashMap();
        map.put("username", account.getUsername());
        map.put("password", account.getPassword());
        Set<Account> accounts = databaseManager.find("from Account a where a.username = :username and a.password = :password", map);
        if(accounts != null && accounts.size() == 1) {
            return true;
        }

        return false;
    }


}
