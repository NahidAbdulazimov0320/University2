package com.example.university.repository;

import com.example.university.entity.auth_entities.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepository extends JpaRepositoryImplementation<Token, Long> {
    @Query("""
select t from Token t inner join User u on t.user.id = u.id
where u.id = :userid and (t.expired = false or t.revoked = false)
""")
    List<Token> findAllValidTokensByUser(Long userid);

    Optional<Token> findByToken(String token);
}
