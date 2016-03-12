package com.funfit.usjr.thesis.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.BreakfastDao;
import com.funfit.usjr.thesis.backend.data.dao.service.DinnerDao;
import com.funfit.usjr.thesis.backend.data.dao.service.FoodDao;
import com.funfit.usjr.thesis.backend.data.dao.service.LunchDao;
import com.funfit.usjr.thesis.backend.data.dao.service.MealsDao;
import com.funfit.usjr.thesis.backend.data.dao.service.SnackDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.dto.RequestMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseMeal;
import com.funfit.usjr.thesis.backend.dto.ResponseStatus;
import com.funfit.usjr.thesis.backend.models.Breakfast;
import com.funfit.usjr.thesis.backend.models.Dinner;
import com.funfit.usjr.thesis.backend.models.Food;
import com.funfit.usjr.thesis.backend.models.Lunch;
import com.funfit.usjr.thesis.backend.models.Meals;
import com.funfit.usjr.thesis.backend.models.Snack;
import com.funfit.usjr.thesis.backend.models.Users;
import com.funfit.usjr.thesis.backend.service.SaveMealService;

@Transactional
@Service("saveMealService")
public class SaveMealServiceImpl implements SaveMealService{

	@Autowired
	private MealsDao mealsDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private BreakfastDao breakfastDao;

	@Autowired
	private LunchDao lunchDao;
	
	@Autowired
	private DinnerDao dinnerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SnackDao snackDao;
	
	private Food food;
	private Breakfast breakfast;
	private Lunch lunch;
	private Dinner dinner;
	private Meals meals;
	private Users user;
	private boolean flag;
	private Snack snack;
	@Override
	public ResponseEntity<ResponseStatus> saveMeal(RequestMeal requestMeal) {
		// TODO Auto-generated method stub
		
		switch (requestMeal.getCourse()){
		case "Breakfast":
			meals = new Meals();
			breakfast = new Breakfast();
			user = userDao.show(requestMeal.getUserId());
			
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			breakfast.setFood(foods);
			breakfastDao.create(breakfast);
			meals.setDate(requestMeal.getDate());
			meals.setBreakfast(breakfast);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			ResponseStatus responseStatus = new ResponseStatus();
			responseStatus.setStatus(true);
			return new ResponseEntity<>(responseStatus, HttpStatus.OK);
			
				
		case "Lunch":
			meals = new Meals();
			lunch = new Lunch();
			user = userDao.show(requestMeal.getUserId());
			
			Food fo = setFood(requestMeal);
			foodDao.create(fo);
			lunch.setFood(fo);
			lunchDao.create(lunch);
			meals.setDate(requestMeal.getDate());
			meals.setLunch(lunch);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			ResponseStatus responseStat = new ResponseStatus();
			responseStat.setStatus(true);
			return new ResponseEntity<>(responseStat, HttpStatus.OK);

				
		case "Dinner":
			meals = new Meals();
			dinner = new Dinner();
			user = userDao.show(requestMeal.getUserId());
			
			Food fod = setFood(requestMeal);
			foodDao.create(fod);
			dinner.setFood(fod);
			dinnerDao.create(dinner);
			meals.setDate(requestMeal.getDate());
			meals.setDinner(dinner);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			ResponseStatus responseStats = new ResponseStatus();
			responseStats.setStatus(true);
			return new ResponseEntity<>(responseStats, HttpStatus.OK);
			
		
		case "Snack":	
			meals = new Meals();
			snack = new Snack();
			user = userDao.show(requestMeal.getUserId());
			Food fos = setFood(requestMeal);
			foodDao.create(fos);
			snack.setFood(fos);
			snackDao.create(snack);
			meals.setDate(requestMeal.getDate());
			meals.setSnack(snack);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
		
		case "Snacks":
			meals = new Meals();
			snack = new Snack();
			user = userDao.show(requestMeal.getUserId());
			Food fs = setFood(requestMeal);
			foodDao.create(fs);
			snack.setFood(fs);
			snackDao.create(snack);
			meals.setDate(requestMeal.getDate());
			meals.setSnack(snack);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	private Food setFood(RequestMeal requestMeal){
		food = new Food();
		
		food.setCalories(requestMeal.getCalories());
		food.setCarbohydrate(requestMeal.getCarbohydrate());
		food.setCholesterol(requestMeal.getCholesterol());
		food.setCourse(requestMeal.getCourse());
		food.setFat(requestMeal.getFat());
		food.setName(requestMeal.getName());
		food.setProtein(requestMeal.getProtein());
		food.setSodium(requestMeal.getSodium());
		return food;
	}

	@Override
	public List<ResponseMeal> queryMealList(int userId) {
		// TODO Auto-generated method stub
		breakfast = new Breakfast();
		food = new Food();
		List<Meals> meals = new ArrayList<>();
		meals = mealsDao.queryMeal(userId);
		ResponseMeal responseMeal = null;
		List<ResponseMeal> responseList = new ArrayList<>();
		for(Meals m: meals){
			try{
				responseMeal = new ResponseMeal();
				breakfast = breakfastDao.show(m.getBreakfast().getBreakfastId());
				food = foodDao.show(breakfast.getFood().getFoodId());
				responseMeal.setCalories(food.getCalories());
				responseMeal.setCarbohydrate(food.getCarbohydrate());
				responseMeal.setCholesterol(food.getCholesterol());
				responseMeal.setCourse(food.getCourse());
				responseMeal.setDate(m.getDate());
				responseMeal.setFat(food.getFat());
				responseMeal.setName(food.getName());
				responseMeal.setProtein(food.getProtein());
				responseMeal.setSodium(food.getSodium());
				responseList.add(responseMeal);
				
			}catch(Exception e){
				
			}

			try{
				responseMeal = new ResponseMeal();
				lunch = lunchDao.show(m.getLunch().getLunchId());
				food = foodDao.show(lunch.getFood().getFoodId());
				responseMeal.setCalories(food.getCalories());
				responseMeal.setCarbohydrate(food.getCarbohydrate());
				responseMeal.setCholesterol(food.getCholesterol());
				responseMeal.setCourse(food.getCourse());
				responseMeal.setDate(m.getDate());
				responseMeal.setFat(food.getFat());
				responseMeal.setName(food.getName());
				responseMeal.setProtein(food.getProtein());
				responseMeal.setSodium(food.getSodium());
				responseList.add(responseMeal);
				
			}catch(Exception e){
				
			}
			
			try{
				responseMeal = new ResponseMeal();
				dinner = dinnerDao.show(m.getDinner().getDinnerId());
				food = foodDao.show(dinner.getFood().getFoodId());
				responseMeal.setCalories(food.getCalories());
				responseMeal.setCarbohydrate(food.getCarbohydrate());
				responseMeal.setCholesterol(food.getCholesterol());
				responseMeal.setCourse(food.getCourse());
				responseMeal.setDate(m.getDate());
				responseMeal.setFat(food.getFat());
				responseMeal.setName(food.getName());
				responseMeal.setProtein(food.getProtein());
				responseMeal.setSodium(food.getSodium());
				responseList.add(responseMeal);
				
			}catch(Exception e){
				
			}

			try{
				responseMeal = new ResponseMeal();
				snack = snackDao.show(m.getSnack().getSnackId());
				food = foodDao.show(snack.getFood().getFoodId());
				responseMeal.setCalories(food.getCalories());
				responseMeal.setCarbohydrate(food.getCarbohydrate());
				responseMeal.setCholesterol(food.getCholesterol());
				responseMeal.setCourse(food.getCourse());
				responseMeal.setDate(m.getDate());
				responseMeal.setFat(food.getFat());
				responseMeal.setName(food.getName());
				responseMeal.setProtein(food.getProtein());
				responseMeal.setSodium(food.getSodium());
				responseList.add(responseMeal);
				
			}catch(Exception e){
				
			}
			
		}
		
		return responseList;
	}

	@Override
	public ResponseEntity<ResponseStatus> saveMealList(List<RequestMeal> requestMealList) {
		// TODO Auto-generated method stub
		ResponseStatus responseStatus = new ResponseStatus();
		
		for(RequestMeal requestMeal: requestMealList){
		
			System.out.println(requestMeal.getName());

			
		if(requestMeal.getCourse().equals("Breakfast")){
		
			meals = new Meals();
			breakfast = new Breakfast();
			user = userDao.show(requestMeal.getUserId());
			System.out.println(requestMeal.getName());
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			breakfast.setFood(foods);
			breakfastDao.create(breakfast);
			meals.setDate(requestMeal.getDate());
			meals.setBreakfast(breakfast);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			responseStatus.setStatus(true);
			}
		else if(requestMeal.getCourse().equals("Lunch")){
			meals = new Meals();
			lunch = new Lunch();
			user = userDao.show(requestMeal.getUserId());
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			lunch.setFood(foods);
			lunchDao.create(lunch);
			meals.setDate(requestMeal.getDate());
			meals.setLunch(lunch);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			responseStatus.setStatus(true);
		}else if(requestMeal.getCourse().equals("Dinner")){
			meals = new Meals();
			dinner = new Dinner();
			user = userDao.show(requestMeal.getUserId());
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			dinner.setFood(foods);
			dinnerDao.create(dinner);
			meals.setDate(requestMeal.getDate());
			meals.setDinner(dinner);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
			responseStatus.setStatus(true);
		}else if(requestMeal.getCourse().equals("Snacks")){
			meals = new Meals();
			snack = new Snack();
			user = userDao.show(requestMeal.getUserId());
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			snack.setFood(foods);
			snackDao.create(snack);
			meals.setDate(requestMeal.getDate());
			meals.setSnack(snack);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
		}else if(requestMeal.getCourse().equals("Snack")){
			meals = new Meals();
			snack = new Snack();
			user = userDao.show(requestMeal.getUserId());
			Food foods = setFood(requestMeal);
			foodDao.create(foods);
			snack.setFood(foods);
			snackDao.create(snack);
			meals.setDate(requestMeal.getDate());
			meals.setSnack(snack);
			meals.setUsers(user.getId());
			mealsDao.create(meals);
		}
		
		}
		
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}
}