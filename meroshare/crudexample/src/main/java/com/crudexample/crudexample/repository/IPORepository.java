package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.entity.IPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPORepository extends JpaRepository<IPO,Long> {
    public IPO findByCode(String code);

}