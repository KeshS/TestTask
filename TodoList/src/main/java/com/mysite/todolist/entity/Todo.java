package com.mysite.todolist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "todolist", schema = "test")
public class Todo  {

    private int id;
    private String shortName;
    private String description;
    private Boolean done = false;
    private Date modifiedDate;

    @Id
    @Column(name = "id", columnDefinition = "INT(8)")
    @GenericGenerator(name = "my_todolist_gen", strategy = "increment")
    @GeneratedValue(generator = "my_todolist_gen")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "modified_date", columnDefinition ="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "description", length = 60)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "shortName", length = 15)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "isDone")
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        if (id != todo.id) return false;
        if (!shortName.equals(todo.shortName)) return false;
        if (!description.equals(todo.description)) return false;
        if (done != null ? !done.equals(todo.done) : todo.done != null) return false;
        return modifiedDate != null ? modifiedDate.equals(todo.modifiedDate) : todo.modifiedDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + shortName.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
