package com.junli;

import com.junli.bank.BankBusinessTemplate;
import com.junli.bank.WithdrawalBusiness;
import com.junli.jdbc.dao.UserDao;
import org.junit.Test;

/**
 * @author lijun
 * @since 2018-03-19 15:37
 */
public class BankTest {

    @Test
    public  void testWithDrawal(){
        BankBusinessTemplate businessTemplate = new WithdrawalBusiness();
        businessTemplate.progress();
    }

    @Test
    public  void testUserDao(){
        UserDao userDao = new UserDao();
        userDao.query();
    }
}
