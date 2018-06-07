package com.resumed.sqtwin.model.responseban;

import java.util.Objects;

/**
 * @auther Super
 * @data 2018/4/18 0018
 * @time 下午 13:49
 */
public class Bean {
    private int id;
    private String name;

    public Bean() {
    }

    public Bean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return id == bean.id &&
                Objects.equals(name, bean.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}