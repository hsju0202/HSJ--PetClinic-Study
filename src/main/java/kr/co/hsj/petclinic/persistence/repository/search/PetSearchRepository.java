package kr.co.hsj.petclinic.persistence.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.persistence.entity.QOwner;
import kr.co.hsj.petclinic.persistence.entity.QPet;
import kr.co.hsj.petclinic.service.model.dto.request.PetRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetSearchRepository {

    private final JPAQueryFactory queryFactory;

    private final QPet pet = QPet.pet;
    private final QOwner owner = QOwner.owner;

    public List<Pet> find(PetRequestDTO.Condition condition) {
        return queryFactory
                .selectFrom(pet)
                .join(owner).fetchJoin()
                .where(petIdIn(condition.getIds()))
                .fetch();
    }

    private BooleanExpression petIdIn(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        return pet.id.in(ids);
    }
}
