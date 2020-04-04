package org.hibernate.HQL;

import javax.persistence.*;

@Entity
@NamedQuery(name="HqlUser.getById",query = "from HqlUser where id = :UserID")
@NamedNativeQuery(name="HqlUser.nativeQuery.getName", query = "select name from HqlUser where id =:UserId")
public class HqlUser {
    private String name;
    @Id @GeneratedValue
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
