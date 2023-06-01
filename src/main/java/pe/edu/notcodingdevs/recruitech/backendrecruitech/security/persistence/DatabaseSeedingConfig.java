package pe.edu.notcodingdevs.recruitech.backendrecruitech.security.persistence;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.service.RoleService;

@Component
public class DatabaseSeedingConfig {
    private final RoleService roleService;

    public DatabaseSeedingConfig(RoleService roleService) {
        this.roleService = roleService;
    }

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        roleService.seed();
    }
}
