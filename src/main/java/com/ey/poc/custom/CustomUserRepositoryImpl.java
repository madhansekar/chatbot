package com.ey.poc.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ey.poc.VO.UsersVO;
import com.ey.poc.entity.RmtCompetency;
import com.ey.poc.entity.RmtCompetencySubTopics;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtIntwUsers;
import com.ey.poc.entity.RmtLevel;
import com.ey.poc.entity.RmtSubCompetency;
import com.ey.poc.entity.RmtSubServiceline;
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository{
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public List<RmtIntwUsers> findAll(UsersVO user) {
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		    javax.persistence.criteria.CriteriaQuery<RmtIntwUsers> cq = cb.createQuery(RmtIntwUsers.class);
		 
		    Root<RmtIntwUsers> userEntity = cq.from(RmtIntwUsers.class);
		    List<Predicate> predicates = new ArrayList<>();
		    Join<RmtIntwUsers,RmtSubServiceline> serviceLineJoin = userEntity.join("rmtSubServiceline", JoinType.INNER);
		    Join<RmtIntwUsers,RmtCompetency> competencyJoin = userEntity.join("rmtCompetency", JoinType.INNER);
		    Join<RmtIntwUsers,RmtSubCompetency> subCompetencyJoin = userEntity.join("rmtSubCompetency", JoinType.INNER);
		    Join<RmtIntwUsers,RmtCompetencyTopics> topicsJoin = userEntity.join("rmtCompeteTopics", JoinType.INNER);
		    Join<RmtIntwUsers,RmtCompetencySubTopics> SubTopicsJoin = userEntity.join("rmtCompetencySubTopics", JoinType.INNER);
		    Join<RmtIntwUsers,RmtLevel>levelJoin = userEntity.join("rmtlevel", JoinType.INNER);
		    
		   
		     
		    if (user.getSubServicelineId() != null) {
		        predicates.add(cb.equal(serviceLineJoin.get("subServicelineId"), user.getSubServicelineId()));
		    }
		    if ( user.getCompetencyId() != 0) {
		        predicates.add(cb.equal(competencyJoin.get("competencyId"), user.getCompetencyId()));
		    }
		    if (user.getSubCompetencyId() != null) {
		        predicates.add(cb.equal(subCompetencyJoin.get("subCompetencyId"), user.getSubCompetencyId()));
		    }
		    if (user.getTopicId() != null) {
		        predicates.add(cb.equal(topicsJoin.get("topicId"), user.getTopicId()));
		    }
		    if (user.getSubTopicId() != null) {
		        predicates.add(cb.equal(SubTopicsJoin.get("subTopicId"), user.getSubTopicId()));
		    }
		    if (user.getLevelId() != null) {
		        predicates.add(cb.equal(levelJoin.get("levelId"), user.getLevelId()));
		    }
		    if (user.getName() != null) {
		        predicates.add(cb.equal(userEntity.get("name"), user.getName()));
		    }
		    if (user.getEmail() != null) {
		        predicates.add(cb.equal(userEntity.get("email"), user.getEmail()));
		    }
		    if (user.getPhoneNumber() != null) {
		        predicates.add(cb.equal(userEntity.get("phoneNumber"), user.getPhoneNumber()));
		    }
		    cq.where(predicates.toArray(new Predicate[0]));
		 
		    return entityManager.createQuery(cq).getResultList();
	}

	
	

}
