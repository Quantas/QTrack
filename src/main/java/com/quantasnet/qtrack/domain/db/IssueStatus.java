package com.quantasnet.qtrack.domain.db;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "issueStatus")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class IssueStatus extends AbstractPersistable<Long>
{
    @Column(name = "issue_status_name", unique = true, nullable = false)
    private String levelName;

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

    public void setLevelName(final String levelName)
    {
        this.levelName = levelName;
    }

    public String getLevelName()
    {
        return levelName;
    }
}