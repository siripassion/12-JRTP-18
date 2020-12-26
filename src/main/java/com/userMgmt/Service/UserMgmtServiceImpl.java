package com.userMgmt.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userMgmt.DTO.City;
import com.userMgmt.DTO.Country;
import com.userMgmt.DTO.State;
import com.userMgmt.DTO.User;
import com.userMgmt.Repository.CityRepository;
import com.userMgmt.Repository.CountryRepository;
import com.userMgmt.Repository.StateRepository;
import com.userMgmt.Repository.UserMgmtRepository;

@Service
public class UserMgmtServiceImpl implements UserMgmtService{
	
	@Autowired
	public UserMgmtRepository userMgmtRepository;
	
	@Autowired
	public CountryRepository countryRepository;
	
	@Autowired
	public StateRepository stateRepository;
	
	@Autowired
	public CityRepository cityRepository;
	
	@Override
	public Map<Integer, String> findCountries() {
		Map<Integer, String> countryMap = new HashMap<>();
		List<Country> countriesList = countryRepository.findAll();
		countriesList.forEach(country->countryMap.put(country.countryId,country.countryName));	
		return countryMap;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		
		Map<Integer, String> stateMap = new HashMap<>();
		List<State> statesList = stateRepository.findAll();
		statesList.forEach(state->stateMap.put(state.stateId,state.stateName));	
		return stateMap;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer, String> cityMap = new HashMap<>();
		List<City> citiesList = cityRepository.findAll();
		citiesList.forEach(city->cityMap.put(city.cityId,city.cityName));
		return null;
	}
	
	@Override
	public String validateCredentials(String email,String password) {
		String accStatus = null;
	    Optional<User> userObj = userMgmtRepository.findByEmailAndPassword(email,password);
	    
	    if(userObj.isPresent()) {
	    	accStatus = userObj.get().getAccountStatus();
	    	
	    	if(accStatus!=null && accStatus.equalsIgnoreCase("LOCKED")) {
	 	    	return  "Your Account Is Locked";
	 	    }else {
	 	    	return "success";
	 	    }
	 	    	
	    }
	    	return  "Invalid Credentials";
	   
	}

	@Override
	public Boolean isEmailExists(String emailId) {
		User user = userMgmtRepository.findByEmail(emailId);
		return user.getSID()!=null;
	}

	@Override
	public Boolean saveUserDetails(User user) {
		if(user!=null && user.getSID()!=null) {
			user.setAccountStatus("LOCKED");
			userMgmtRepository.save(user);
		}
		return user.getSID()!=null;
	}

	@Override
	public Boolean isTempPasswordValid(String email,String tmpPwd) {
		
		Optional<User> userObj = userMgmtRepository.findByEmailAndPassword(email,tmpPwd);
	    
	   return userObj.get().SID!=null;
	}

	@Override
	public Boolean unlockAccount(String email, String newPassword) {
		User user = userMgmtRepository.findByEmail(email);
		user.setPassword(newPassword);
		user.setAccountStatus("UNLOCKED");
		User updatedUser = userMgmtRepository.save(user);
		return updatedUser.getSID()!=null;
	}

	@Override
	public String forgotPassword(String email) {
		User user = userMgmtRepository.findByEmail(email);
		if(user!=null){
			return user.getPassword();
		}
		return null;
	}

	
}
