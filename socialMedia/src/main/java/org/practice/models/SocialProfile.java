package org.practice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private SocialUser socialUser;

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public void setSocialUser(SocialUser socialUser){
        this.socialUser = socialUser;
        if(this.socialUser.getSocialProfile()!=this){
            this.socialUser.setSocialProfile(this);
        }
    }

}
