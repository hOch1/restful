package api.restful.repository;

import api.restful.domain.Board;
import api.restful.domain.Good;
import api.restful.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GoodRepository extends JpaRepository<Good, Long> {
    Optional<Good> findByMemberAndBoard(Member member, Board board);

    Boolean existsByMember_IdAndBoard_Id(Long member_id, Long board_id);
}
