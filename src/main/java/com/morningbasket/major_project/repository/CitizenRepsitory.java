package com.morningbasket.major_project.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morningbasket.major_project.entity.CitizenEntity;
@Repository
public interface CitizenRepsitory extends JpaRepository<CitizenEntity, Serializable>{

}
