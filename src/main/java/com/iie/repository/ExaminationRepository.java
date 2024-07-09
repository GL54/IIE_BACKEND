package com.iie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iie.model.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
