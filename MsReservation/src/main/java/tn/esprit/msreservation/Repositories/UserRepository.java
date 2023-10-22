package tn.esprit.msreservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreservation.Entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
