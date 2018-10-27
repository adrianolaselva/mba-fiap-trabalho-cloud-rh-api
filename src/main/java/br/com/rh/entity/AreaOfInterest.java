package br.com.rh.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class AreaOfInterest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public AreaOfInterest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
