package br.com.conciliator.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class AreaOfInterest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AreaOfInterest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
