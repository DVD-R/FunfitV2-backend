package com.funfit.usjr.thesis.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funfit.usjr.thesis.backend.dto.RequestMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseStatus;
import com.funfit.usjr.thesis.backend.service.SaveMealService;

@RestController
public class MealController {

	
	@Autowired
	private SaveMealService saveMealService;
	
	@RequestMapping(value = "/saveMeal",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.POST)
	public List<ResponseMeal> saveMeal(@RequestBody RequestMeal requestMeal){
		 saveMealService.saveMeal(requestMeal);
		return saveMealService.queryMealList(requestMeal.getUserId());
	}
	
	
	@RequestMapping(value = "/queryMealList",
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.GET)
	public List<ResponseMeal> queryMealList(@RequestParam(value = "userId")int userId){
		return saveMealService.queryMealList(userId);
	}
	
	@RequestMapping(value = "/saveMealList",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.POST)
	public ResponseEntity<ResponseStatus> saveMealList(@RequestBody List<RequestMeal> requestMealList){
		return saveMealService.saveMealList(requestMealList);
	}
}