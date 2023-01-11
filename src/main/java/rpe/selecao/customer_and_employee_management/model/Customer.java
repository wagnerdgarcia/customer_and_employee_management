package rpe.selecao.customer_and_employee_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Customer extends Person{

    @Column
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
}
