package api.restful.repository;

import api.restful.domain.Board;
import api.restful.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByMember_Id(Long memberId);
    List<Board> findByMember(Member member);
}
