package com.quantasnet.qtrack.domain.db;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project extends AbstractPersistable<Long>
{
    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_desc")
    private String projectDesc;

    @Column(name = "project_tag")
    private String projectTag;

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

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectDesc()
    {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc)
    {
        this.projectDesc = projectDesc;
    }

    public String getProjectTag()
    {
        return projectTag;
    }

    public void setProjectTag(String projectTag)
    {
        this.projectTag = projectTag;
    }
}