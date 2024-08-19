package org.example.webassignment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "information_seq_gen")
    @SequenceGenerator(name = "information_seq_gen", sequenceName = "information_seq", allocationSize = 1, initialValue = 1)
    @Id
    private Integer id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "username", length = 255)
    private String userName;

    @Column(name = "user_email", length = 255)
    private String email;

    @Column(name = "user_password", length = 255)
    private String password;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "contact", length = 255)
    private Long contactNumber;
}
