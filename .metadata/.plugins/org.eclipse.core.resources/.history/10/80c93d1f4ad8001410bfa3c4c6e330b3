package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue
	private int userId;
	
	private String firstName;
	
	@ManyToMany()
	@JoinTable(name="MOVIES_USERS",
	joinColumns={@JoinColumn(name="UserId")},
	inverseJoinColumns={@JoinColumn(name="MovieId")})
	private List<Movie> movies = new ArrayList<Movie>();

	public int getUserId() {
		return userId;
	}

	public List<Movie> getMovies() {
		return movies;
	}



	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return firstName;
	}

}
