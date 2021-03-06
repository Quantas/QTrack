package com.quantasnet.qtrack.web.app;

import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.IssueService;
import com.quantasnet.qtrack.service.ProjectService;
import com.quantasnet.qtrack.service.RoleService;
import com.quantasnet.qtrack.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class QTrackDBFiller implements ApplicationListener<ContextRefreshedEvent>
{
    private final Logger log = LoggerFactory.getLogger(QTrackDBFiller.class);

    @Resource
    private IssueService issueService;

    @Resource
    private ProjectService projectService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        final List<IssueStatus> statuses = issueService.findAllStatusTypes();

        // TODO need a better check here, but valid for now
        if (statuses.isEmpty())
        {
            log.info("Populating empty DB with default data");

            // create new statuses
            final IssueStatus status = issueService.saveStatus("New");
            issueService.saveStatus("Assigned");
            issueService.saveStatus("Closed");

            // create new project
            final Project project = projectService.save("DEMO", "Demo Project", "A demo project");

            // create roles
            final List<Role> rolesAll = new ArrayList<Role>();
            final List<Role> rolesUser = new ArrayList<Role>();

            final Role role = roleService.save("ROLE_USER");
            rolesAll.add(role);
            rolesUser.add(role);

            final Role adminRole = roleService.save("ROLE_ADMIN");
            rolesAll.add(adminRole);

            // create users
            final User admin = userService.save("admin", "Admin", "Administrator", "admin@test.com", "admin", rolesAll);
            userService.save("user", "User", "Userton", "user@test.com", "user", rolesUser);

            // create an issue
            issueService.save("Test Issue", "A Test Issue", project, status, admin);
        }
        else
        {
            log.info("Data present --- Not populating DB with default data");
        }
    }
}