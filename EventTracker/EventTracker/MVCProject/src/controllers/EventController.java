package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.ActivityDAO;
import src.entities.Activity;

@RestController
public class EventController {
	
	@Autowired
	ActivityDAO activityDao;
	
	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "distance", method = RequestMethod.GET)
	public List<Activity> index() {
		return activityDao.index();
	}
	
	@RequestMapping(path = "distance/{id}", method = RequestMethod.GET)
	public Activity show(@PathVariable int id) {
		return activityDao.show(id);
	}
	
	
	@RequestMapping(path = "distance", method = RequestMethod.POST)
	public Activity create(@RequestBody String jsonDistance, HttpServletResponse res) {
		res.setStatus(201);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Activity distance = mapper.readValue(Activity.class, 1);
			return activityDao.create(newActivity);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	@RequestMapping(path = "distance/{id}", method = RequestMethod.PUT)
	public Activity update(@PathVariable int id, HttpServletResponse response) {
		response.setStatus(202);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Activity newActivity = mapper.readValue(Activity.class, 1);
			return activityDao.update(id, newActivity);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	@RequestMapping(path = "distance/{id}", method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return activityDao.destroy(id);
	}
}