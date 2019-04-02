package com.hyj.framework.model.po;

/**
 * @author huyuanjia
 * @date 2019/4/2 17:10
 */
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Data
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    @Id
    @Column
    private Long id;

    /**
     * 省份编号
     */
    @Column
    private Long provinceId;

    /**
     * 城市名称
     */
    @Column
    private String cityName;

    /**
     * 描述
     */
    @Column
    private String description;


}
