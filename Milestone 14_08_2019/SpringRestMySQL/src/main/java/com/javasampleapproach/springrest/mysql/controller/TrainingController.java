package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Training;
import com.javasampleapproach.springrest.mysql.repo.TrainingRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TrainingController {

	@Autowired
	TrainingRepository trainingRepository;

	/*
	 * @Autowired TrainingService trainingService;
	 */
	@GetMapping("/trainings/getTrainingDetails/{id}")
	public Optional<Training> getTrainingDetails(@PathVariable("id") Long id) {
		/* System.out.println("Get all Customers..."); */

		return trainingRepository.findById(id);

	}

	@GetMapping("/trainings/getCompletedTrainings/{userId}")
	public List<Training> getCompletedTrainings(@PathVariable("userId") Long userId)
	{

		List<Training> trainings = trainingRepository.findByUserId(userId);
		List<Training> getCompletedTraining=new ArrayList<>();
		for(Training training:trainings)
		{
			if(training.getStatus().equals("Completed"))
			{
				getCompletedTraining=trainings;
			}
		}
		return getCompletedTraining;


	}

	@GetMapping("/trainings/getUnderProgressTrainings/{userId}")
	public List<Training> getUnderProgressTrainings(@PathVariable("userId") Long userId)
	{

		List<Training> trainings = trainingRepository.findByUserId(userId);
		List<Training> getUnderProgressTraining=new ArrayList<>();
		for(Training training:trainings)
		{
			if(training.getStatus().equals("In Progress"))
			{
				getUnderProgressTraining=trainings;
			}
		}

		return getUnderProgressTraining;

	}

	@PostMapping(value="/trainings/create")
	public Training createTrainings(@RequestBody Training training) {

		Training _training = trainingRepository.save(new Training(training.getStatus(),training.getProgress(), training.getCommissionAmount(),training.getRating(), training.getAvgRating(), training.getStartDate(),
				training.getEndDate(), training.getStartTime(), training.getEndDate(), training.getAmountReceived(), training.getUserId(), training.getUserName(),
				training.getMentorId(), training.getMentorName(),training.getSkillId(), training.getSkillName(), training.getFees()));
		return _training;
	}

	@GetMapping(value="trainings/proposeTraining/{id}")
	public Optional<Training> proposeTraining(@PathVariable("id") Long id)
	{
		int result=trainingRepository.changeStatus("Proposed", id);
		return  trainingRepository.findById(id);

	}

	@GetMapping(value="trainings/approveTraining/{id}")
	public Optional<Training> approveTraining(@PathVariable("id") Long id)
	{ 
		int result=trainingRepository.changeStatus("Approved", id);
		return trainingRepository.findById(id);

	}
	
	@GetMapping(value="trainings/finalizeTraining/{id}")
	public Optional<Training> finalizeTraining(@PathVariable("id") Long id)
	{ 
		int result=trainingRepository.changeStatus("Finalized", id);
		return trainingRepository.findById(id);
		
	}





}
