package org.portfolio.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Messages {

    private String sender;

    private String receiver;

    private String message;

    private Date receivedDate;

    private boolean isSeen;
}
