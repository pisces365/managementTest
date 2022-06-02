package com.xiangliban.managementsystem.dao.mapper;

import com.xiangliban.managementsystem.pojo.Vote.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/09/13:41
 * @Description:
 */

@Mapper //表示mybatis的mapper类
@Repository  //整合进spring
public interface VoteMapper {
    List<VoteType> selectAllVoteType();

    List<VoteInfo> selectVoteDetailsByType(String type);

    VoteInfo selectVoteDetailById(String id);

    List<VoteInfo> selectAllVoteDetail();

    VotePersonSelect selectVotePersonDetailsById(String uid, String voteinfoid);

    List<VotePersonSelect> selectVotePersonDetailsByVoteInfoId(String voteinfoid);


    void addVoteType(String id, String name);

    void updateVoteType(String id, String name);

    void deleteVoteType(String id);


    void addVoteInfo(@Param("voteInfo") VoteInfo voteInfo);

    void deleteVoteInfo(String id);


    void addVotePerson(@Param("votePerson") VotePerson votePerson);

    void deleteVotePerson(String id);


    List<VoteInfo> selectVoteDetailsByTime(String start, String end);


    void addVoteRecord(@Param("voteRecord") VoteRecord voteRecord);

    void updatePersonVote(String voteid);

    int selectVoteRecord(String voteInfoId, String votePersonUid, String uid);
}
