package com.quantasnet.qtrack.domain.db;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Issue extends AbstractAuditable<User, Long>
{
    @Column(name = "issue_title")
    private String title;

    @Column(name = "issue_desc")
    private String desc;

    @ManyToOne(targetEntity = IssueStatus.class)
    private IssueStatus issueStatus;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @ManyToOne(targetEntity = User.class)
    private User assignedTo;

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

    public IssueStatus getIssueStatus()
    {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus)
    {
        this.issueStatus = issueStatus;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project project)
    {
        this.project = project;
    }

    public User getAssignedTo()
    {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo)
    {
        this.assignedTo = assignedTo;
    }
}