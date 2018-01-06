package data;

import java.util.List;

import entities.Activity;

public interface ActivityDAO {
	public List<Activity> index();
	public Activity show(int id);
	public Activity create(String jsonDistance);
	public Activity update(int id, Activity distance);
	public boolean destroy(int id);
}
