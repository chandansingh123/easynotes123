package com.chandan.easynotes123.Model;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userProfile")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt,updateAt"},allowGetters = true)
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private Gender gender;

    @NotBlank
    private String DOB;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @NotBlank
    private Status status;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    public static List <UserProfile> findAll() {
        return null;
    }
}
