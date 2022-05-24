package com.resliv.turbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Long chat_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "state")
    private State state;

    @ManyToOne
    @JoinColumn(name = "chosen_city")
    private City city;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    private Boolean isAdmin;

}