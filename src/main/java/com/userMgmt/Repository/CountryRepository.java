package com.userMgmt.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMgmt.DTO.Country;

public interface CountryRepository extends JpaRepository<Country,Serializable>{

}
