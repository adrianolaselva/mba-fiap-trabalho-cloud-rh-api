package br.com.conciliator.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String tellefone;
    private String cellPhone;

    public Contact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTellefone() {
        return tellefone;
    }

    public void setTellefone(String tellefone) {
        this.tellefone = tellefone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
