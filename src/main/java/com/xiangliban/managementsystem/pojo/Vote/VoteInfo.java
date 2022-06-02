package com.xiangliban.managementsystem.pojo.Vote;

import lombok.Data;

@Data
public class VoteInfo {
    private String id;
    private String name;
    private int state;
    private String department;
    private String intro;
    private String start;
    private String end;
    private String img;
    private String type;
}
