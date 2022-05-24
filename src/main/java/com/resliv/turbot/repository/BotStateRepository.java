package com.resliv.turbot.repository;

import com.resliv.turbot.model.BotState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotStateRepository extends JpaRepository<BotState, Long> {
}
