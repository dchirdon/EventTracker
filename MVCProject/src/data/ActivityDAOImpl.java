package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.entities.Activity;

@Repository
@Transactional
public class ActivityDAOImpl implements ActivityDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override 
	public List<Activity> index() {
		String query = "select distinct distance from activity";
	}

	@Override
	public Activity create(Activity activity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTracker");
		EntityManager em = emf.createEntityManager();

		em.persist(activity);
		em.flush();

		em.close();
		emf.close();

		return activity;
	}

	@Override
	public Activity update(int id, Activity activity) { 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTracker");
		EntityManager em = emf.createEntityManager();

		Activity activity = em.find(Activity.class, id);
		activity.setId(activity.getId());
		activity.setName(activity.getName());

		return activity;
	}

	@Override
	public boolean destroy(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventTracker");
		EntityManager em = emf.createEntityManager();

		Activity activity = em.find(Activity.class, id);
		// em.getTransaction().begin();

		em.remove(activity);

		activity.getName();

		if (em.find(Activity.class, id) == null) {
			return true;
		} else

			em.close();
		emf.close();
		return false;

	}
}
	