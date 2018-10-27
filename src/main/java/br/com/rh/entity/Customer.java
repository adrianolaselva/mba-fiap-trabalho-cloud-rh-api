package br.com.rh.entity;

import br.com.rh.enums.Genre;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Document(collection = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public String id;

    public String photograph;
    public String documentNumber;

    @NotNull(message = "firstName não pode ser vazio")
    public String firstName;

    @NotNull(message = "lastName não pode ser vazio")
    public String lastName;
    public Genre genre;
    public Calendar dateOfbirth;
    public String email;
    public List<Contact> contacts;
    public List<Address> adresses;
    public List<AreaOfInterest> areasOfInterest;
    public String objective;
    public BigDecimal salaryPretension;
    public List<Graduation> graduations;

    public Customer() {

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Calendar getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Calendar dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Address> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Address> adresses) {
        this.adresses = adresses;
    }

    public List<AreaOfInterest> getAreasOfInterest() {
        return areasOfInterest;
    }

    public void setAreasOfInterest(List<AreaOfInterest> areasOfInterest) {
        this.areasOfInterest = areasOfInterest;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public BigDecimal getSalaryPretension() {
        return salaryPretension;
    }

    public void setSalaryPretension(BigDecimal salaryPretension) {
        this.salaryPretension = salaryPretension;
    }

    public List<Graduation> getGraduations() {
        return graduations;
    }

    public void setGraduations(List<Graduation> graduations) {
        this.graduations = graduations;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", photograph='" + photograph + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

