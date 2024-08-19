package org.example.webassignment.repo;

import org.example.webassignment.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM tbl_user " +
            "WHERE username = ?1 AND user_password = ?2")
    User findByUsernameAndPassword(String username, String password);
}
