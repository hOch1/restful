package api.restful.repository;

import api.restful.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Long> {

    void deleteByMember_IdAndBoard_Id(Long member_id, Long board_id);

    Boolean existsByMember_IdAndBoard_Id(Long member_id, Long board_id);
}
