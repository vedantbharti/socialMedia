package org.practice.serviceImpl;


import org.practice.models.SocialGroup;
import org.practice.models.SocialPost;
import org.practice.models.SocialUser;
import org.practice.repository.SocialGroupRepository;
import org.practice.repository.SocialPostRepository;
import org.practice.repository.SocialProfileRepository;
import org.practice.repository.SocialUserRepository;
import org.practice.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    SocialGroupRepository socialGroupRepository;
    @Autowired
    SocialPostRepository socialPostRepository;
    @Autowired
    SocialUserRepository socialUserRepository;
    @Autowired
    SocialProfileRepository socialProfileRepository;

    @Override
    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public List<SocialGroup> getAllGroups(){
        return socialGroupRepository.findAll();
    }

    @Override
    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }
}
