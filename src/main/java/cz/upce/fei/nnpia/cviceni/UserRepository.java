package cz.upce.fei.nnpia.cviceni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<AppUser, Integer> {
    List<AppUser> findByActive(boolean active);
}
