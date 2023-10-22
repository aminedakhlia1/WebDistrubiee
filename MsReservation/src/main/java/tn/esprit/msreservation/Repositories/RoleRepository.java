package tn.esprit.msreservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreservation.Entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
