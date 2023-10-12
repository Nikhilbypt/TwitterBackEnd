package com.twitter.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;


public class Verification {

    private boolean status=false;
    private LocalDateTime startedAt;
    private LocalDateTime endAt;

}
