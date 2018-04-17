package com.chandan.easynotes123.dto;

import com.chandan.easynotes123.Model.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Gender gender;
    private String dob;
}
