package com.resliv.turbot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state_messages")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateMessage {

    @Id
    @GeneratedValue
    private Long id;
    private String state;
    private String message;
}
