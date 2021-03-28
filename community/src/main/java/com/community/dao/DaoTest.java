package com.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.24.17:45
 */
@Repository("dao")
public class DaoTest implements DaoDemo{
    @Override
    public String select() {
        return "DaoTest select";
    }
}
