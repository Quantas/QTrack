package com.quantasnet.qtrack.domain.db;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue extends AbstractPersistable<Long>
{
    @Column(name = "issue_title")
    private String title;

    @Column(name = "issue_desc")
    private String desc;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    /////////////////////////////////////////////
    // These methods required for EL stupidness
    /////////////////////////////////////////////
    @Override
    public void setId(Long id)
    {
        super.setId(id);
    }

    @Override
    public Long getId()
    {
        return super.getId();
    }
    /////////////////////////////////////////////
    // End stupidness methods
    /////////////////////////////////////////////

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