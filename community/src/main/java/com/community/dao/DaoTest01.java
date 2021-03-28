package com.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.24.17:56
 */
@Repository
@Primary
public class DaoTest01 implements DaoDemo{
    @Override
    public String select() {
        return "DaoTest01 select";
    }
}
