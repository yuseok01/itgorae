package com.soowan.oauth.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soowan.oauth.domain.UserDomain;

@Repository
public interface UserRepository extends CrudRepository<UserDomain,String> {
	Optional<UserDomain> findByEmailAndOauthType(String emailm, String oauthType);
	
}
