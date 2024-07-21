package org.practice.repository;

import org.practice.models.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialPostRepository extends JpaRepository<SocialPost, Long> {
}
