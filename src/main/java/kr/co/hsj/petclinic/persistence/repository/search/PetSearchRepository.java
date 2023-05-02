package kr.co.hsj.petclinic.persistence.repository.search;

import static kr.co.hsj.petclinic.infra.util.QueryUtils.filter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.persistence.entity.QOwner;
import kr.co.hsj.petclinic.persistence.entity.QPet;
import kr.co.hsj.petclinic.service.model.dto.request.PetRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
            .where(
                filter(condition.getIds(), pet.id::in),
                filter(condition.getOwnerId(), owner.id::in)
            )
            .fetch();
    }

}
