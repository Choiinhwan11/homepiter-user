package com.homepiter.user.user.entity;

import com.homepiter.commons.enums.RBAC;
import com.homepiter.commons.enums.UserGender;
import com.homepiter.commons.enums.UserStatus;
import com.homepiter.user.profile.entity.UserProfile;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(
        name = "user",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"user_email"}) }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "사용자 이름은 필수 항목입니다.")
    private String userName;

    @Column(nullable = false, unique = true, name = "user_id")
    @NotBlank(message = "유저 ID는 필수 항목입니다.")
    private String userId;

    @Column(nullable = false, name = "user_pwd")
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String userPassword;

    @Column(nullable = false, unique = true, name = "user_email")
    @Email(message = "유효한 이메일 형식을 입력해주세요.")
    private String userEmail;

    @Column(nullable = false, name = "user_phone" )
    private String userPhone;

    @Column(nullable = false, name = "user_post")
    private String userPost;

    @Column(nullable = false, name = "user_addr")
    private String userAddress;

    @Column(nullable = false, name = "user_addr2")
    private String userDetailAddress;

    /* 성별 (Enum) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_gender")
    private UserGender userGender;

    /* 상태 (RBAC Enum) */
    @Enumerated(EnumType.STRING)
    private RBAC rbac;

    /* 회원 가입 형태 */
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private boolean emailVerified = false; // ✅ 기본값 false 설정

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile profile;

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Builder
    public User(String userId, String userEmail, String userName, String userPassword, String userPhone,
                String userPost, String userAddress, String userDetailAddress, String userGender, boolean emailVerified) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPost = userPost;
        this.userAddress = userAddress;
        this.userDetailAddress = userDetailAddress;
        this.emailVerified = emailVerified;
    }


}
