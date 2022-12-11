package com.mahdiyeh.restfulwebservice.repository;

import com.mahdiyeh.restfulwebservice.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
}