package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.dao.mapper.VoteMapper;
import com.xiangliban.managementsystem.pojo.Vote.VoteInfo;
import com.xiangliban.managementsystem.pojo.Vote.VotePerson;
import com.xiangliban.managementsystem.pojo.Vote.VoteRecord;
import com.xiangliban.managementsystem.pojo.Vote.VoteType;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

@RunWith( Parameterized.class)
@SpringBootTest(classes = VoteService.class)
public class VoteServiceTest extends TestCase {
    private String id;
    private String name;
    private String id_info;
    private String name_info;
    private int state;
    private String department;
    private String intro;
    private String start;
    private String end;
    private String img_info;
    private String type;
    private String voteid;
    private String uid;
    private String voteinfoid;
    private String duty;
    private String brief_intro;
    private String outlook;
    private String votes;
    private String img_person;
    private String id_record;
    private String voteInfoId;
    private String votePersonUid;;
    private String uid_record;
    private VoteService voteService;
    private VoteMapper voteMapper;
    public VoteServiceTest(String id, String name, String id_info, String name_info, int state, String department, String intro, String start,
                           String end, String img_info, String type, String voteid, String uid, String voteinfoid, String duty, String brief_intro,
                           String outlook, String votes, String img_person, String id_record, String voteInfoId, String votePersonUid, String uid_record) {
        this.id=id;
        this.name=name;
        this.id_info=id_info;
        this.name_info=name_info;
        this.state=state;
        this.department=department;
        this.intro=intro;
        this.start=start;
        this.end=end;
        this.img_info=img_info;
        this.type=type;
        this.voteid=voteid;
        this.uid=uid;
        this.voteinfoid=voteinfoid;
        this.duty=duty;
        this.brief_intro=brief_intro;
        this.outlook=outlook;
        this.votes=votes;
        this.img_person=img_person;
        this.id_record=id_record;
        this.voteInfoId=voteInfoId;
        this.votePersonUid=votePersonUid;
        this.uid_record=uid_record;
    }


    @Parameterized.Parameters(name = "{index}: id = {0}, name = {1}, id_info = {2}, name_info = {3}, state = {4}, department = {5}, " +
            "intro = {6}, start = {7}, end = {8}, img_info = {9}, type = {10}, voteid = {11}, uid = {12}, " +
            "voteinfoid = {13}, duty = {14}, brief_intro = {15}, outlook = {16}, outlook = {17}," +
            " img_person = {18}, id_record = {19}, voteInfoId = {20}, votePersonUid = {21}, uid_record = {22}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1", "村长换届", "1","2021村长选", 1,"xx村委会","本次选举共产生1名村长，共四位候选人",
                        "2021-12-08 18:24:24","2021-12-08 18:24:27","http://p1362.bvimg.com/10465/b7a23d05f09c09ae.jpg",
                        "1","1SqfX4tPMcJD2z","User#1","1","string","string","1","string","string","20211224135419","1","User#1","User#1" },
                /*{ "", "", "","", 0,"","","","","","","","","","","","","","","","","",""},
                { "", "", "","", 0,"","","","","","","","","","","","","","","","","",""},*/
        });
    }

    @Before
    public void setUp() throws Exception {
        voteService = new VoteService();
        voteMapper = EasyMock.createMock(VoteMapper.class);
        voteService.setVoteMapper(voteMapper);
    }

    @After
    public void tearDown() throws Exception {
    }
      @Test
      public void testSelectAllVoteType(){
          List<VoteType> voteInfos = new ArrayList<>();
              for(int i = 0; i < 4; i++){
                  VoteType voteInfo = new VoteType();
                  voteInfo .setId(id);
                  voteInfo .setName(name);

                  voteInfos.add(voteInfo);
          }
          expect(voteMapper.selectAllVoteType()).andReturn(voteInfos);
          replay(voteMapper);
          assertEquals(voteInfos, voteService.selectAllVoteType());
      }
    @Test
    public void testSelectVoteDetailById(){
        List<VoteInfo> voteInfos = new ArrayList<>();
        VoteInfo voteInfo_test=new VoteInfo();
        if(id_info == null || "".equals(id_info)){
            voteInfos = null;
        }else{
            for(int i = 0; i < 4; i++){
                VoteInfo voteInfo = new VoteInfo();
                voteInfo .setId(id_info);
                voteInfo .setName(name_info);
                voteInfo .setState(state);
                voteInfo .setDepartment(department);
                voteInfo .setIntro(intro);
                voteInfo .setStart(start);
                voteInfo .setEnd(end);
                voteInfo .setImg(img_info);
                voteInfo .setType(type);
                if(voteInfo .getId().equals(id_info)){
                    voteInfo_test=voteInfo;
                }

            }
        }
        expect(voteMapper.selectVoteDetailById(id_info)).andReturn(voteInfo_test);
        replay(voteMapper);
        assertEquals(voteInfo_test, voteService.selectVoteDetailById(id_info));
    }
    @Test
    public void testAddVoteType() {
        VoteType voteType=new VoteType();
        voteType.setName(name);
       /* voteService.addVoteType(name);*/
        voteMapper.addVoteType(IdConsturctor.idConsturctor(),name);
        voteService.addVoteType(name);
    }
    @Test
    public void testAddVoteInfo() {
        VoteInfo voteInfo = new VoteInfo();
        voteInfo .setId(id_info);
        voteInfo .setName(name_info);
        voteInfo .setState(state);
        voteInfo .setDepartment(department);
        voteInfo .setIntro(intro);
        voteInfo .setStart(start);
        voteInfo .setEnd(end);
        voteInfo .setImg(img_info);
        voteInfo .setType(type);
        voteService.addVoteInfo(voteInfo);
    }
    @Test
    public void testUpdateVoteType() {
        voteService.updateVoteType(id,name);
    }
    @Test
    public void testDeleteVoteType() {
        voteService.deleteVoteType(id);
    }
    @Test
    public void testDeleteVoteInfo() {
        voteService.deleteVoteInfo(id_info);
    }
    @Test
    public void testAddVotePerson() {
        VotePerson votePerson=new VotePerson();
        votePerson.setVoteid(voteid);
        votePerson.setUid(uid);
        votePerson.setVoteinfoid(voteinfoid);
        votePerson.setDuty(duty);
        votePerson.setBrief_intro(brief_intro);
        votePerson.setOutlook(outlook);
        votePerson.setVotes(votes);
        votePerson.setImg(img_person);
        voteService.addVotePerson(votePerson);
    }
    @Test
    public void testDeleteVotePerson() {
        voteService.deleteVotePerson(voteid);
    }
    @Test
    public void testSelectVoteDetailsByTime(){
        List<VoteInfo> voteInfos = new ArrayList<>();
        if(start == null || "".equals(end)||end == null || "".equals(start)){
            voteInfos = null;
        }else{
            for(int i = 0; i < 4; i++){

                VoteInfo voteInfo = new VoteInfo();
                voteInfo .setId(id_info);
                voteInfo .setName(name_info);
                voteInfo .setState(state);
                voteInfo .setDepartment(department);
                voteInfo .setIntro(intro);
                voteInfo .setStart(start);
                voteInfo .setEnd(end);
                voteInfo .setImg(img_info);
                voteInfo .setType(type);
                if(voteInfo.getStart().equals(start)&&voteInfo.getEnd().equals(end)){
                    voteInfos.add(voteInfo);
                }

            }
        }
        expect(voteMapper.selectVoteDetailsByTime(start,end)).andReturn(voteInfos);
        replay(voteMapper);
        assertEquals(voteInfos, voteService.selectVoteDetailsByTime(start,end));
    }
    @Test
    public void testAddVoteRecord() {
        VoteRecord voteRecord = new VoteRecord();
        voteRecord.setId(id);
        voteService.addVoteRecord(voteRecord);
    }
    @Test
    public void testSelectAllVoteDetail(){
        List<VoteInfo> voteInfos = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            VoteInfo voteInfo = new VoteInfo();
            voteInfo .setId(id);
            voteInfos.add(voteInfo);
        }
        expect(voteMapper.selectAllVoteDetail()).andReturn(voteInfos);
        replay(voteMapper);
        assertEquals(voteInfos, voteService.selectAllVoteDetail());
    }
}
