package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Activity;

@Repository
@Transactional
public class ActivityDAOImpl implements ActivityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Activity> index() {
		String query = "SELECT distinct a from Activity a";
		List<Activity> activity = em.createQuery(query).getResultList();
		return activity;
	}

	@Override
	public Activity create(String jsonDistance) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
		Activity newActivity = mapper.readValue(jsonDistance, Activity.class);
		em.persist(newActivity);
		em.flush();
		return newActivity;
		} catch (Exception e) {
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public Activity update(int id, Activity activity) {

		Activity distance = em.find(Activity.class, id);
		distance.setId(activity.getId());
		distance.setName(activity.getName());

		return distance;
	}

	@Override
	public boolean destroy(int id) {

		Activity activity = em.find(Activity.class, id);
		// em.getTransaction().begin();

		em.remove(activity);

		activity.getName();

		if (em.find(Activity.class, id) == null) {
			return true;
		} else

			return false;

	}

	@Override
	public Activity show(int id) {
		return null;
	}
}
















