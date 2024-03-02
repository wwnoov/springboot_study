package com.example.demo.dao;

import com.example.demo.vo.QnaVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    @Resource(name="boardSqlSessionTemplate")
    private SqlSession boardSqlSession;

    public List list(){
        return boardSqlSession.selectList("board.list"); //List<QnaVo>
    }

    public int write(QnaVo vo){
        return boardSqlSession.insert("board.write",vo);
    }

}
