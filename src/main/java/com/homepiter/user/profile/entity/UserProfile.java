package com.homepiter.user.profile.entity;//package com.homepiter.commons.enums;

import com.homepiter.user.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @jakarta.persistence.Id
    @Id
    private Long id;
    //대표 이미지 URL
    private String profileBackImgURL;

    //프로필 이미지 URL
    private String profileImgURL;

    /*user entity import */
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



}
