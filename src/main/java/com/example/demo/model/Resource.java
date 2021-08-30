package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_resource", schema = "public")
public class Resource {
    public Resource(){}

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "resource_id")
    private String resourceId;

    @Column(name = "dataset_id")
    private String datasetId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;
}
