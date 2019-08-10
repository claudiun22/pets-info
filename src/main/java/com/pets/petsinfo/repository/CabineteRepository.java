package com.pets.petsinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pets.petsinfo.model.Cabinete;
import com.pets.petsinfo.model.Pensiuni;

public interface CabineteRepository extends JpaRepository<Cabinete, Long>{
	
	public List<Cabinete> findDistinctByLocatie(String locatie);
	
	public List<String> findLocatie();

}
