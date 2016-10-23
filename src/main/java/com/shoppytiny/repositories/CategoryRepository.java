package com.shoppytiny.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppytiny.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findByName(String name);
}
