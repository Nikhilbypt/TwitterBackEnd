package com.twitter.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "likes")
@Data
public class Like   {
    @Id
    private String likeId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tweet tweet;




    public Like() {
        this.likeId = UUID.randomUUID().toString();
    }
}
