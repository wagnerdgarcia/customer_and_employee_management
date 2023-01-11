package rpe.selecao.customer_and_employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpe.selecao.customer_and_employee_management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
