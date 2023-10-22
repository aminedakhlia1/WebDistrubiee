package tn.esprit.msrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msrendezvous.Entities.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
