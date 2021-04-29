package com.cg.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.phonebook.domain.UserEntity;

@Repository
public interface PhonebookUsersRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByUserIdentifier(String userIdentifier);
}
