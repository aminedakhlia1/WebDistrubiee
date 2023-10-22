package tn.esprit.msrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msrendezvous.Entities.User;

public interface UserRepo extends JpaRepository<User,Long> {
}
