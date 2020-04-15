package com.wludio.microservice.pmp.entities;

import com.wludio.microservice.pmp.entities.enums.Role;
import com.wludio.microservice.pmp.entities.enums.UserState;
import lombok.Data;

import javax.persistence.*;

import static com.wludio.microservice.pmp.entities.constants.Schema.PLATFORM_MANAGEMENT;
import static com.wludio.microservice.pmp.entities.constants.Schema.USER_MANAGEMENT;

@Data
@Entity
@Table(name="user", schema = USER_MANAGEMENT)
public class User extends BaseEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="avatar")
    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private UserState state;

	//Not persistent. There is no column on database table.
    @Transient
    private String token;
}

