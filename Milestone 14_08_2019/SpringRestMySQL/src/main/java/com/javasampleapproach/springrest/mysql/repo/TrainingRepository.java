package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.springrest.mysql.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Long> {
	/* List<Training> findByAge(int age); */ 
	
	List<Training> findByUserId(Long userId);
	@Modifying
	@Transactional
	@Query("update Training t set t.status=:status where t.id=:id")
	int changeStatus(@Param("status") String status,
			@Param("id") Long id);
	

	}
