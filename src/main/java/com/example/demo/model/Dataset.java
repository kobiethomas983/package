package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_dataset", schema = "public")
public class Dataset {

    public Dataset() {}
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "dataset_id")
    private String datasetId;

    @Column(name = "owner_id")
    private String ownerId;

    private String description;
    private String name;

    @Column(name = "package_id")
    private String packageId;

    @Column(name = "created_at")
    private Timestamp createAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

}
