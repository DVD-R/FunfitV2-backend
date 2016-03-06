package com.funfit.usjr.thesis.backend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.dto.RequestMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseStatus;

@Transactional
public interface SaveMealService{
	public ResponseEntity<ResponseStatus> saveMeal(RequestMeal requestMeal);
	public List<ResponseMeal> queryMealList(int userId);
	public ResponseEntity<ResponseStatus> saveMealList(List<RequestMeal> requestMeal);
}
