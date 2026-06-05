package org.portfolio.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="images")
@Getter
@NoArgsConstructor
public class Image extends BaseEntity {

    @Column
    private String imageName;
}
