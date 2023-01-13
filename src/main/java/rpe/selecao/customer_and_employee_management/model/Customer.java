package rpe.selecao.customer_and_employee_management.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Customer extends Person{

    @Column(nullable = false)
    private Date dateLastService;


    public Customer(){}
    public Customer(final String document, final String name, final String address, final String phone, final Date dateLastService){
        super(document, name, phone, address);
        this.dateLastService = dateLastService;
    }

    public Date getDateLastService() {
        return dateLastService;
    }

    public void setDateLastService(Date dateLastService) {
        this.dateLastService = dateLastService;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "dateLastService=" + dateLastService +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (!super.equals(o)) return false;
        return getDateLastService().equals(customer.getDateLastService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateLastService());
    }
}
