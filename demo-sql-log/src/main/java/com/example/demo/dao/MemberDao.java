package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MemberDao {
    @Autowired
    @Resource(name="memberSqlSessionTemplate")
    private SqlSession memberSqlSession;

    public List list(){
        return memberSqlSession.selectList("member.list"); //List<QnaVo>
    }
}
