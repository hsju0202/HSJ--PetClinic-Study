package kr.co.hsj.petclinic.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hsj.petclinic.persistence.entity.QPet;
import kr.co.hsj.petclinic.persistence.entity.QVisit;
import kr.co.hsj.petclinic.persistence.entity.Visit;
import kr.co.hsj.petclinic.service.model.dto.request.VisitRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VisitSearchRepository {

    private final JPAQueryFactory queryFactory;

    private final QVisit visit = QVisit.visit;
    private final QPet pet = QPet.pet;

    public List<Visit> find(VisitRequestDTO.Condition condition) {
        return queryFactory
                .selectFrom(visit)
                .join(pet).fetchJoin()
                .where(visitIdIn(condition.getIds()))
                .fetch();
    }

    private BooleanExpression visitIdIn(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        return visit.id.in(ids);
    }
}
