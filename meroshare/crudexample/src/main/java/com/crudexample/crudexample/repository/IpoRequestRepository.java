package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.entity.Customer;
import com.crudexample.crudexample.entity.IpoApplyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IpoRequestRepository extends JpaRepository<IpoApplyRequest,Long> {

    @Query("SELECT SUM(m.applyQuantity) FROM IpoApplyRequest m WHERE m.ipo.id = :n")
    public int count(@Param("n") long id);
@Query("SELECT u FROM IpoApplyRequest u WHERE u.customer.id =:n AND u.ipo.id = :m")
    IpoApplyRequest findByCid(@Param("n") long id, @Param("m") long id1);
}


