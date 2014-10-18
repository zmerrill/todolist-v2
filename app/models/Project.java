package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Project extends Model{
	@Id
	public Long id;
	public String name;
	@ManyToOne
	public User user;
	
	public Project(String name, User owner){
		this.name = name;
		this.user = owner;
	}
	
	public static Finder<Long, Project> find = new Finder<Long, Project>(Long.class, Project.class);
	
	public static Project create(String name, String ownerEmail){
		Project project = new Project(name, User.find.ref(ownerEmail));
		project.save();
		return project;
	}
	
	
}