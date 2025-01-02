package com.project.spring.monthlyexpensestracker.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ItemListJpa extends JpaRepository<Item,Integer> {


    List<Item> findByUsername(String username);

}
