package com.gousade.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author woxigsd@gmail.com
 * @date 2020-8-31 14:24:04
 * @description
 */
@Data
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Builder // 链式风格创建对象
@ApiModel(description = "接口调用日志实体类")
public class OperationRecordLog implements Serializable {

    private static final long serialVersionUID = 3960814623848073582L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String operationPerson;

    private int operationNum;

    private String operationDescription;

    private String operationInterface;

    private String operationParam;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private boolean delflag;

}
