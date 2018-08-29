package com.AssignmentSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssignmentSpringBoot.Entity.Invoicedetail;

public interface InvoiceDetailRepository extends JpaRepository<Invoicedetail, Integer> {

}
