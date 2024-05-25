package com.ssafy.ssaccer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssaccer.model.dao.TeamDao;
import com.ssafy.ssaccer.model.dao.TeamRecruitmentBoardDao;
import com.ssafy.ssaccer.model.dto.SearchCondition;
import com.ssafy.ssaccer.model.dto.TeamRecruitmentBoard;

@Service
public class TeamRecruitmentBoardServiceImpl implements TeamRecruitmentBoardService {

    private final TeamRecruitmentBoardDao boardDao;
    private final TeamDao teamDao;

    @Autowired
    public TeamRecruitmentBoardServiceImpl(TeamRecruitmentBoardDao boardDao, TeamDao teamDao) {
        this.boardDao = boardDao;
        this.teamDao = teamDao;
    }

    @Override
    public List<TeamRecruitmentBoard> searchBoard(SearchCondition searchCondition) {
        return boardDao.search(searchCondition);
    }
    
    @Override
    public TeamRecruitmentBoard readBoard(int id) {
        // boardDao.updateViewCnt(id);
        return boardDao.selectOne(id);
    }

    @Override
    public boolean writeBoard(TeamRecruitmentBoard board) {
        return boardDao.insertBoard(board) == 1;
    }
    
    @Override
    public boolean removeBoard(int id) {
        return boardDao.deleteBoard(id) == 1;
    }
    @Override
    public boolean modifyBoard(TeamRecruitmentBoard board) {
        return boardDao.updateBoard(board) == 1;
    }
}
