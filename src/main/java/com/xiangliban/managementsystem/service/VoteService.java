package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.dao.mapper.VoteMapper;
import com.xiangliban.managementsystem.pojo.Vote.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/09/13:41
 * @Description:
 */

@Repository
public class VoteService {

    @Autowired
    private VoteMapper voteMapper;
    public void setVoteMapper(VoteMapper voteMapper){this.voteMapper=voteMapper;}

    public List<VoteType> selectAllVoteType() {
        return voteMapper.selectAllVoteType();
    }

    public List<VoteInfo> selectVoteDetailsByType(String type) {
        return voteMapper.selectVoteDetailsByType(type);
    }

    public VoteInfo selectVoteDetailById(String id) {
        return voteMapper.selectVoteDetailById(id);
    }

    public List<VoteInfo> selectAllVoteDetail() {
        return voteMapper.selectAllVoteDetail();
    }

    public VotePersonSelect selectVotePersonDetailsById(String uid, String voteinfoid) {
        return voteMapper.selectVotePersonDetailsById(uid, voteinfoid);
    }

    public List<VotePersonSelect> selectVotePersonDetailsByVoteInfoId(String voteinfoid) {
        return voteMapper.selectVotePersonDetailsByVoteInfoId(voteinfoid);
    }


    public void addVoteType(String name) {
        voteMapper.addVoteType(IdConsturctor.idConsturctor(), name);
    }

    public void updateVoteType(String id, String name) {
        voteMapper.updateVoteType(id, name);
    }

    public void deleteVoteType(String id) {
        voteMapper.deleteVoteType(id);
    }


    public String addVoteInfo(VoteInfo voteInfo) {
        String id = IdConsturctor.idConsturctor();
        voteInfo.setId(id);
        voteMapper.addVoteInfo(voteInfo);
        return id;
    }

    public void deleteVoteInfo(String id) {
        voteMapper.deleteVoteInfo(id);
    }


    public void addVotePerson(VotePerson votePerson) {
        votePerson.setVoteid(NameGenerator.nameGenerator(14));
        voteMapper.addVotePerson(votePerson);
    }

    public void deleteVotePerson(String id) {
        voteMapper.deleteVotePerson(id);
    }


    public List<VoteInfo> selectVoteDetailsByTime(String start, String end) {
        return voteMapper.selectVoteDetailsByTime(start, end);
    }


    public void addVoteRecord(VoteRecord voteRecord) {
        voteRecord.setId(IdConsturctor.idConsturctor());
        voteMapper.addVoteRecord(voteRecord);
    }

    public void updatePersonVote(String voteid) {
        voteMapper.updatePersonVote(voteid);
    }

    public int selectVoteRecord(String voteInfoId, String votePersonUid, String uid) {
        return voteMapper.selectVoteRecord(voteInfoId, votePersonUid, uid);
    }


}
