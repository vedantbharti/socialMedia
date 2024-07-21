package org.practice.service;

import org.practice.models.SocialGroup;
import org.practice.models.SocialPost;
import org.practice.models.SocialUser;

import java.util.List;

public interface SocialService {

    List<SocialUser> getAllUsers();

    List<SocialGroup> getAllGroups();

    SocialUser saveUser(SocialUser socialUser);
}
