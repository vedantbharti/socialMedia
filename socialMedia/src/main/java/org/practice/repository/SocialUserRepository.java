package org.practice.repository;

import org.practice.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
