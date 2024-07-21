package org.practice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long username;
    @OneToOne(mappedBy = "socialUser", cascade = CascadeType.ALL)
    @JsonManagedReference
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SocialPost> socialPosts;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"), name = "user_group")
    @JsonBackReference
    private Set<SocialGroup> socialGroups = new HashSet<>();

    public void setSocialProfile(SocialProfile socialProfile){
        this.socialProfile = socialProfile;
        if(this.socialProfile.getSocialUser()!=this){
            this.socialProfile.setSocialUser(this);
        }
    }

//    public void setSocialPosts(List<SocialPost> socialPosts){
//        socialPosts.stream().forEach(socialPost -> socialPost.setSocialUser(this));
//        this.socialPosts = socialPosts;
//    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
