package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
