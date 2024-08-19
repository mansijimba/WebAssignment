package org.example.webassignment.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String address;
    private Long contactNumber;
}
