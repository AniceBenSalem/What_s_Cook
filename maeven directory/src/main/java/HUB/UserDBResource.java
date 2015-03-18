package HUB;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/userdb")
@Produces(MediaType.APPLICATION_JSON)
public class UserDBResource {
	private static UserDao dao = App.dbi.open(UserDao.class);
	
	public UserDBResource() {
		try {
			dao.createUser();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
		dao.insertUser("toto","toto2","tro");
	}
	
/*	@POST
	public User createUser(User user) {
		int id = dao.insert(user.getName());
		user.setId(id);
		return user;
	}
*/	
	@GET
	@Path("/{name}")
	public String getUser(@PathParam("name") String name) {
		/*User out = dao.findByName(name);
		if (out == null) {
		System.out.println(name);
		throw new WebApplicationException(404);
		}
		return out;*/
		System.out.println("ici");
		return name;
	}
}