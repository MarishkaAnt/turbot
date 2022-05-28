package com.resliv.turbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String name;
    private Long botState;


    @ManyToOne
    @JoinColumn(name = "chosen_city")
    private City city;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    private Boolean isAdmin;

}
