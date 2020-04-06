package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.PrepareType;

@Repository
public interface PrepareTypeRepository extends JpaRepository<PrepareType, Integer> {
	
}
