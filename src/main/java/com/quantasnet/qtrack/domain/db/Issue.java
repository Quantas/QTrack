package com.quantasnet.qtrack.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue
{
    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "issue_title")
    private String title;

    @Column(name = "issue_desc")
    private String desc;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project project)
    {
        this.project = project;
    }
}