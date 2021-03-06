package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_source", schema = "public")
public class Source {
    public Source(){}

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "source_id")
    private String sourceId;

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
