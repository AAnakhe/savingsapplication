package org.aspacelife.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.aspacelife.model.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
