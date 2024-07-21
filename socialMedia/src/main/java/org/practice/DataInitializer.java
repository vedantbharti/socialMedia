package org.practice;

import org.practice.models.SocialGroup;
import org.practice.models.SocialPost;
import org.practice.models.SocialProfile;
import org.practice.models.SocialUser;
import org.practice.repository.SocialGroupRepository;
import org.practice.repository.SocialPostRepository;
import org.practice.repository.SocialProfileRepository;
import org.practice.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialGroupRepository groupRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final SocialPostRepository socialPostRepository;

    public DataInitializer(SocialUserRepository userRepository, SocialGroupRepository groupRepository, SocialProfileRepository socialProfileRepository, SocialPostRepository postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.socialPostRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            // Create some posts
            SocialPost post1 = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            // Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            socialPostRepository.save(post1);
            socialPostRepository.save(post2);
            socialPostRepository.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepository)
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
        };
    }
}
