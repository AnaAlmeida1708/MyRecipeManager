package br.com.myrecipemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
