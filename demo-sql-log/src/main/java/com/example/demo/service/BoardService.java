package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.MemberDao;
import com.example.demo.vo.QnaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    @Autowired
    private MemberDao memberDao;
    public HashMap list(){
        QnaVo vo = new QnaVo();
        vo.setTitle("test");
        vo.setUserId("yyb");
        int id = boardDao.write(vo);
        System.out.println(id);
        System.out.println(vo);

        HashMap result = new HashMap();
        result.put("board",boardDao.list());
        result.put("member",memberDao.list());
        return result;
    }
}
