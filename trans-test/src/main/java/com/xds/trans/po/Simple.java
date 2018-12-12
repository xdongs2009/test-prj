package com.xds.trans.po;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "simple")
public class Simple {

    private Long id;
    private String name;
    private Timestamp createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Simple(String name, Timestamp createTime) {
        this.name = name;
        this.createTime = createTime;
    }
}
