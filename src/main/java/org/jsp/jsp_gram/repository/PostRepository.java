package org.jsp.jsp_gram.repository;
import java.util.List;
import org.jsp.jsp_gram.dto.Post;
import org.jsp.jsp_gram.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByUserIn(List<User> users);

}
