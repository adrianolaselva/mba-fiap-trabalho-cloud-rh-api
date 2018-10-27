package br.com.rh.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String telefone;
    private String cellPhone;

    public Contact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
