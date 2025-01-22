package org.jsp.jsp_gram.dto;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;
@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imageUrl;
	private String caption;
	@UpdateTimestamp
	private LocalDateTime postedTime;
	@Transient
	private MultipartFile image;
	@ManyToOne
	private User user;
	@ManyToMany(fetch = FetchType.EAGER)
	List<User> likedUsers = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Comment> comments = new ArrayList<Comment>();
	
	public boolean hasLiked(int id) {
		for (User likedUser : likedUsers) {
			if (likedUser.getId() == id) {
				return true;
			}
		}
		return false;
	}
}