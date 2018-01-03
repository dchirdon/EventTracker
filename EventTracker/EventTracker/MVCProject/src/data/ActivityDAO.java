package data;

import java.util.List;

public interface ActivityDAO {
	public List<activity> index();
	public Activity show(int id);
	public Activity create(Activity distance);
	public Activity update(int id, Activity distance);
	public boolean destroy(int id);
}
