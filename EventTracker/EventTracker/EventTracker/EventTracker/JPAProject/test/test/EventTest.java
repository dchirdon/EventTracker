package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Activity;


public class EventTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Activity activity;


	@Before
	public void setUp() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("EventPU");
		this.em = emf.createEntityManager();
		activity = em.find(Activity.class, 1);
		                              
	}

	@After
	public void tearDown() throws Exception {
		this.em.close();
		this.emf.close();
	}
	
	@Test
	public void test() {
	  boolean pass = true;
	  assertEquals(pass, true);
	}

	@Test
	public void test_quiz_mapping() {
	 	activity = em.find(Activity.class, 1);
    	assertEquals("running", activity.getName());
	}
}
