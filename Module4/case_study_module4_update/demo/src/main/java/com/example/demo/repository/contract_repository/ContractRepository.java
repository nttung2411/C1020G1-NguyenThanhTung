package com.example.demo.repository.contract_repository;

import com.example.demo.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

    @Query("select c from Contract c where (?1 between c.startDateContract and c.endDateContract) or (c.customer.customerName like ?1) or (c.employee.employeeName like ?1)")
    Page<Contract> findContractByDate(String search, Pageable pageable);

}
