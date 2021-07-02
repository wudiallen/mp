package com.dong.entity;

import com.baomidou.mybatisplus.annotation.*;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author songchao
 * @since 2021-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生id")
    @TableId(value = "sid", type = IdType.ASSIGN_UUID)
    private String sid;
    @ApiModelProperty(value = "学生姓名")
    private String sname;
    @ApiModelProperty(value = "学生性别")
    private String sex;
    @ApiModelProperty(value = "学生年龄")
    private Integer sage;
    @ApiModelProperty(value = "学生生日")
    private Date sbirthday;
    @ApiModelProperty(value = "老师id")
    private Integer cid;
    @ApiModelProperty(value = "删除状态")
    @TableLogic(value = "0",delval = "1")
    private Integer deleteflag;
    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    private Date insertTime;
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
