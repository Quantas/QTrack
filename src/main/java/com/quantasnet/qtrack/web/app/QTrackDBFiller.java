package com.quantasnet.qtrack.web.app;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.IssueService;
import com.quantasnet.qtrack.service.ProjectService;
import com.quantasnet.qtrack.service.RoleService;
import com.quantasnet.qtrack.service.UserService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

            final List<Role> rolesAll = new ArrayList<Role>();
            final List<Role> rolesUser = new ArrayList<Role>();

            final Role role = new Role();
            role.setRoleName("ROLE_USER");
            roleService.save(role);
            rolesAll.add(role);
            rolesUser.add(role);

            final Role adminRole = new Role();
            adminRole.setRoleName("ROLE_ADMIN");
            roleService.save(adminRole);
            rolesAll.add(adminRole);

            User admin = new User();
            admin.setActive(true);
            admin.setRoles(rolesAll);
            admin.setEmail("admin@test.com");
            admin.setGravatarHash(userService.generateGravatarHash(admin.getEmail()));
            admin.setFirstName("Admin");
            admin.setLastName("Administrator");
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin = userService.save(admin);

            User user = new User();
            user.setActive(true);
            user.setRoles(rolesUser);
            user.setEmail("user@test.com");
            user.setGravatarHash(userService.generateGravatarHash(user.getEmail()));
            user.setFirstName("User");
            user.setLastName("Userton");
            user.setUserName("user");
            user.setPassword(passwordEncoder.encode("user"));
            user = userService.save(user);

            // create an issue
            final Issue issue = new Issue();
            issue.setCreatedDate(DateTime.now());
            issue.setIssueStatus(status);
            issue.setProject(project);
            issue.setTitle("Test Issue");
            issue.setDesc("A test issue");
            issue.setCreatedBy(admin);
            issueService.save(issue);
        }
        else
        {
            log.info("Data present --- Not populating DB with default data");
        }
    }
}