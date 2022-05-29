package com.resliv.turbot.repository;

import com.resliv.turbot.model.StateMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StateMessageRepository extends JpaRepository<StateMessage, Long> {

    @Modifying
    @Query("update StateMessage s set s.message = ?1 where s.state = ?2")
    void setMessageByState(String message, String state);
}
