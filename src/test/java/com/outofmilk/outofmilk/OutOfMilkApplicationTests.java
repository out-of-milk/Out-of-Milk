package com.outofmilk.outofmilk;

import com.outofmilk.outofmilk.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OutOfMilkApplicationTests {

    @Autowired
    private UserRepository userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void deletePantryItem() {
        userDao.deleteIngredientById(2L, 10L);
    }
    @Test
    public void deletePantryItemId() {
        userDao.deletePantryIngredientById(47L);
    }

}
