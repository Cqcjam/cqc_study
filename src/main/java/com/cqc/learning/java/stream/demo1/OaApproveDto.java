package com.cqc.learning.java.stream.demo1;

import lombok.Data;

/**
 * oa审批操作记录
 * @author caoqingcong
 */
@Data
public class OaApproveDto {

    private String approveTime;

    private String operateRemark;

    private String operateUser;

    private Integer operateStatus;
}
