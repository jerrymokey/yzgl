package com.jerry.yzgl.yw.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dic")
public class Dic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
      private String id;

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 字典码
     */
    private String dicCode;


}
