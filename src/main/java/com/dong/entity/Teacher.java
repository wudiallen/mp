package com.dong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value="Teacher对象", description="")
@Accessors(chain = true)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "教师id")
    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;
    @ApiModelProperty(value = "教师姓名")
    private String tname;
    @ApiModelProperty(value = "教师教学科目")
    private String tsubject;
    @ApiModelProperty(value = "教师密码")
    private String tpassword;
    @ApiModelProperty(value = "教师激活标记")
    private Integer flag;
    @ApiModelProperty(value = "教师邮箱")
    private String temail;


}
