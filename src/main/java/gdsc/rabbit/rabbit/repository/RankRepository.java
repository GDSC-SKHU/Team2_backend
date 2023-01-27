package gdsc.rabbit.rabbit.repository;

import gdsc.rabbit.rabbit.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

    Optional<Rank> findById(Long id);

    Optional<Rank> findByMember_Name(String name);
}
