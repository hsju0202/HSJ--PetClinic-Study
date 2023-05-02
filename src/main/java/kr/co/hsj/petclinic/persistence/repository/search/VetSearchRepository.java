package kr.co.hsj.petclinic.persistence.repository.search;

import static kr.co.hsj.petclinic.infra.util.QueryUtils.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hsj.petclinic.persistence.entity.QVet;
import kr.co.hsj.petclinic.persistence.entity.Vet;
import kr.co.hsj.petclinic.service.model.dto.request.VetRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VetSearchRepository {

    private final JPAQueryFactory queryFactory;

    private final QVet vet = QVet.vet;

    public List<Vet> find(VetRequestDTO.Condition condition) {
        return queryFactory
            .selectFrom(vet)
            .where(
                filter(condition.getIds(), vet.id::in)
            )
            .fetch();
    }

    private BooleanExpression vetIdIn(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }

        return vet.id.in(ids);
    }
}
