package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void isIdValid(Long id)
    {
        if(id <= 0)
        {
            throw new BurgerException("Id is wrong", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isBurgerNullForDML(Burger burger)
    {
        if(burger == null)
        {
            throw new BurgerException("Burger not found",HttpStatus.BAD_REQUEST);
        }
    }

    public static void isBurgerNullForDatabase(Burger burger)
    {
        if(burger == null)
        {
            throw new BurgerException("Burger not found",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
