package com.example.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    WishListService wishListService;

    @Test
    public void searchTest() {
        var result = wishListService.search("베테랑", "", "");
        System.out.println(result);

        Assertions.assertNotNull(result);
    }
}
