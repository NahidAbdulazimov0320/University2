package com.example.university.repository;

import com.example.university.entity.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepositoryImplementation<Token, Long> {
    @Query("""
select t from Token t inner join User u on t.user.id = u.id
where u.id = :userid and (t.expired = false or t.revoked = false)
""")
    List<Token> findAllValidTokensByUser(Long userid);

    Optional<Token> findByToken(String token);
}
