package com.maciej.imiela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Address;
import com.maciej.imiela.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }

    public Address findOne(int id) {
        return this.addressRepository.findOne(id);
    }

    public void save(Address address) {
        this.addressRepository.save(address);

    }
}
