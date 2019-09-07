package eko.study.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eko.study.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
