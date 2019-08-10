package com.pets.petsinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pets.petsinfo.model.Pensiuni;

public interface PensiuniRepository extends JpaRepository<Pensiuni, Long>{
	
	public List<Pensiuni> findDistinctByOras(String oras);
	
	public List<String> findOrase();
	
}
