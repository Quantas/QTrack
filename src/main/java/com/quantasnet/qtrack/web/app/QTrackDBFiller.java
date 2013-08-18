package com.quantasnet.qtrack.web.app;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.service.IssueService;
import com.quantasnet.qtrack.service.ProjectService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class QTrackDBFiller implements ApplicationListener<ContextRefreshedEvent>
{
    private final Logger log = LoggerFactory.getLogger(QTrackDBFiller.class);

    @Resource
    private IssueService issueService;

    @Resource
    private ProjectService projectService;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        final List<IssueStatus> statuses = issueService.findAllStatusTypes();

        // TODO need a better check here, but valid for now
        if(statuses.isEmpty())
        {
            log.info("Populating empty DB with default data");

            // create new status
            IssueStatus status = new IssueStatus();
            status.setLevelName("New");
            status = issueService.saveStatus(status);

            IssueStatus assigned = new IssueStatus();
            assigned.setLevelName("Assigned");
            issueService.saveStatus(assigned);

            IssueStatus closed = new IssueStatus();
            closed.setLevelName("Closed");
            issueService.saveStatus(closed);

            // create new project
            Project project = new Project();
            project.setProjectTag("DEMO");
            project.setProjectName("Demo Project");
            project.setProjectDesc("A demo project");
            project = projectService.save(project);

            // create an issue
            final Issue issue = new Issue();
            issue.setCreatedDate(DateTime.now());
            issue.setIssueStatus(status);
            issue.setProject(project);
            issue.setTitle("Test Issue");
            issue.setDesc("A test issue");
            issueService.save(issue);
        }
        else
        {
            log.info("Data present --- Not populating DB with default data");
        }
    }
}