package com.realestate.manager.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.manager.entities.Executive;

public interface ExecutiveRepository extends JpaRepository<Executive, Integer> {

	List<Executive> findByLocality(String locality);
}
