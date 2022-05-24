package com.resliv.turbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BotState {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String message;
}
