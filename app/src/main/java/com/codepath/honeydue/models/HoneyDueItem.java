package com.codepath.honeydue.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

/**
 * Created by jndukuba on 9/3/17.
 */
@Table(database = HoneyDueDatabase.class)
public class HoneyDueItem extends BaseModel implements Serializable {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    @Column
    @PrimaryKey
    private int id;

    @Column
    private String name;

    @Column
    private Priority priority;

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}
