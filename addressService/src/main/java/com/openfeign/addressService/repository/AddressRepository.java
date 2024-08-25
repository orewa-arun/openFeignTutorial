package com.openfeign.addressService.repository;

import com.openfeign.addressService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT ea.id, ea.city, ea.state FROM testDB.address ea join testDB.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
