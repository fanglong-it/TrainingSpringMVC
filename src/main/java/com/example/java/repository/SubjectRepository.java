package com.example.java.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.java.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query(nativeQuery = true, value = "select count(id) as total from subject")
	int getTotalSubject();

	List<Subject> findByNameContains(String name, Pageable pageable);
}
