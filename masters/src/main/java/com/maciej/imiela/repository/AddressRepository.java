package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
