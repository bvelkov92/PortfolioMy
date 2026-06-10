package org.portfolio.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Messages extends BaseEntity {

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String message;

    private Date receivedDate;

    private boolean isSeen;
}
