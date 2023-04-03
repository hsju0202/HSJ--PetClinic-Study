package kr.co.hsj.petclinic.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hsj.petclinic.persistence.entity.Owner;
import kr.co.hsj.petclinic.persistence.entity.QOwner;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OwnerSearchRepository {

    private final JPAQueryFactory queryFactory;

    private final QOwner owner = QOwner.owner;

    public List<Owner> find(OwnerRequestDTO.Condition condition) {
        return queryFactory
                .selectFrom(owner)
                .where(ownerIdIn(condition.getIds())                )
                .fetch();
    }

    private BooleanExpression ownerIdIn(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        return owner.id.in(ids);
    }
}
