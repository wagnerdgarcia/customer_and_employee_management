package rpe.selecao.customer_and_employee_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class Employee extends Person{
    @Column(nullable = false)
    private String function;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date dateContact;

    public Employee(){}
    public Employee(final String document, final String name, final String address, final String phone, String function,String status,Date dateContact){
        super(document, name, phone, address);
        this.function = function;
        this.status = status;
        this.dateContact = dateContact;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateContact() {
        return dateContact;
    }

    public void setDateContact(Date dateContact) {
        this.dateContact = dateContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "function='" + function + '\'' +
                ", status='" + status + '\'' +
                ", dateContact=" + dateContact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getFunction(), employee.getFunction()) && Objects.equals(getStatus(), employee.getStatus()) && Objects.equals(getDateContact(), employee.getDateContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFunction(), getStatus(), getDateContact());
    }
}
