package com.rlsp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product extends PanacheEntity {

    public String name;
    public BigDecimal value;

    @CreationTimestamp
    public Date dateCreation;

    @UpdateTimestamp
    public Date dateUpdate;


}
