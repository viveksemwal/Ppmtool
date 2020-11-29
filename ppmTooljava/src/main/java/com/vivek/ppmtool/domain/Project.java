package com.vivek.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Project name cannot be null")
    private String projectName;
    @NotBlank(message = "Identifier Required")
    @Size(min = 4,max = 5,message = "Only for Character")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;
    @Lob
    @Size(min = 4,max = 100,message ="minimum 4 max 100 character")
    @NotBlank
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateAt;


    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateAt=new Date();
    }



}
