package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_package", schema = "public")
public class Package {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "package_id")
    private String packageId;

    private String name;
    private String category;
    private String description;
    private String country;

    @Column(name= "owner_id")
    private String ownerId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

}
