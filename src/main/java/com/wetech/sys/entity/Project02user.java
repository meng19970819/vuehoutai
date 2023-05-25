package com.wetech.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mengmeng
 * @since 2023-05-25
 */
public class Project02user implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String usersname;

    private String userspassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }
    public String getUserspassword() {
        return userspassword;
    }

    public void setUserspassword(String userspassword) {
        this.userspassword = userspassword;
    }

    @Override
    public String toString() {
        return "Project02user{" +
            "id=" + id +
            ", usersname=" + usersname +
            ", userspassword=" + userspassword +
        "}";
    }
}
