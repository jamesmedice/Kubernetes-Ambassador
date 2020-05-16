package com.medici.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medici.model.OauthUser;

/**
 * 
 * @author a73s
 *
 */
public interface OauthUserRepository extends JpaRepository<OauthUser, String> {

	@Query("SELECT DISTINCT user FROM OauthUser user  INNER JOIN FETCH user.authorities AS authorities WHERE user.username = :username")
	OauthUser findByUsername(String username);

}