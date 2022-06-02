package com.xiangliban.managementsystem.pojo.Express;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/23:08
 * @Description:
 */
@Data
public class PackageProcess {
    private String packageProcessId;
    private String packageId;
    private String processTime;
    private int packageState;
    private String stateDetails;
}
