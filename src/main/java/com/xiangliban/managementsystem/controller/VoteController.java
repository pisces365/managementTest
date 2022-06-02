package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.pojo.Vote.*;
import com.xiangliban.managementsystem.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/09/13:41
 * @Description:
 */
@Api(tags = "选举接口类")
@RestController
@CrossOrigin
public class VoteController {

    @Autowired
    private VoteService voteService;

    @ApiOperation("获取所有选举类型")
    @GetMapping("/vote/allVoteType")
    public List<VoteType> selectAllVoteType() {
        return voteService.selectAllVoteType();
    }

    @ApiOperation("根据选举类型type获取所有该类型的选举信息")
    @GetMapping("/vote/voteDetailsByType")
    public List<VoteInfo> selectVoteDetailsByType(String type) {
        return voteService.selectVoteDetailsByType(type);
    }

    @ApiOperation("根据选举信息表id获取该条选举信息")
    @GetMapping("/vote/voteDetailById")
    public VoteInfo selectVoteDetailById(String id) {
        return voteService.selectVoteDetailById(id);
    }

    @ApiOperation("根据选举信息id和用户id获取特定选举人信息")
    @GetMapping("/vote/votePersonDetailsById")
    public VotePersonSelect selectVotePersonDetailsById(String uid, String voteinfoid) {
        return voteService.selectVotePersonDetailsById(uid, voteinfoid);
    }

    @ApiOperation("根据选举信息id获取所有参选选举人信息")
    @GetMapping("/vote/votePersonDetailsByVoteInfoId")
    public List<VotePersonSelect> selectVotePersonDetailsByVoteInfoId(String voteinfoid) {
        return voteService.selectVotePersonDetailsByVoteInfoId(voteinfoid);
    }


    @ApiOperation("增加选举类型")
    @PostMapping("/vote/addVoteType")
    public void addVoteType(String name) {
        voteService.addVoteType(name);
    }

    @ApiOperation("修改选举类型")
    @PostMapping("/vote/updateVoteType")
    public void updateVoteType(String id, String name) {
        voteService.updateVoteType(id, name);
    }

    @ApiOperation("根据id删除选举类型")
    @PostMapping("/vote/deleteVoteType")
    public void deleteVoteType(String id) {
        voteService.deleteVoteType(id);
    }


    @ApiOperation("新增选举信息（图片请传入URL）(id字段使用任意字串占位）返回：生成id主键值")
    @PostMapping("/vote/addVoteInfo")
    public String addVoteInfo(@RequestBody VoteInfo voteInfo) {
        return voteService.addVoteInfo(voteInfo);
    }

    @ApiOperation("根据id删除选举信息")
    @PostMapping("/vote/deleteVoteInfo")
    public void deleteVoteInfo(String id) {
        voteService.deleteVoteInfo(id);
    }


    @ApiOperation("新增被选举人信息（图片请传入URL）(voteid字段使用任意字串占位）")
    @PostMapping("/vote/addVotePersons")
    public void addVotePersons(@RequestBody List<VotePerson> votePerson) {
        for (VotePerson v : votePerson) {
            voteService.addVotePerson(v);
        }

    }

    @ApiOperation("新增被选举人信息（图片请传入URL）(voteid字段使用任意字串占位）")
    @PostMapping("/vote/addVotePerson")
    public void addVotePerson(@RequestBody VotePerson votePerson) {
        voteService.addVotePerson(votePerson);
    }

    @ApiOperation("根据id删除选举人信息")
    @PostMapping("/vote/deleteVotePerson")
    public void deleteVotePerson(String id) {
        voteService.deleteVotePerson(id);
    }


    @ApiOperation("根据选举时间start和end（必须都输入）获取所有该时间的选举信息（模糊搜索）")
    @GetMapping("/vote/VoteDetailsByTime")
    public List<VoteInfo> selectVoteDetailsByTime(String start, String end) {
        return voteService.selectVoteDetailsByTime(start, end);
    }


    @ApiOperation("记录哪一个村民uid对哪一个选举活动vote_info_id中的哪一个被选举人vote_person_uid进行了投票")
    @PostMapping("/vote/addVoteRecord")
    public void addVoteRecord(@RequestBody VoteRecord voteRecord) {
        voteService.addVoteRecord(voteRecord);
    }

    @ApiOperation("更新被选举人得票数，增加1，voteid为被选举人表的唯一主键")
    @GetMapping("/vote/updatePersonVote")
    public void updatePersonVote(String voteid) {
        voteService.updatePersonVote(voteid);
    }

    @ApiOperation("在选举记录表中查找是否存在投票")
    @GetMapping("/vote/selectVoteRecord")
    public int selectVoteRecord(String voteInfoId, String votePersonUid, String uid) {
        return voteService.selectVoteRecord(voteInfoId, votePersonUid, uid);
    }


    @ApiOperation("获取所有选举信息")
    @GetMapping("/vote/selectAllVoteDetail")
    public List<VoteInfo> selectAllVoteDetail() {
        return voteService.selectAllVoteDetail();
    }
}
