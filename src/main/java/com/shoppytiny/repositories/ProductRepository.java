package com.shoppytiny.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppytiny.domain.Category;
import com.shoppytiny.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p from Product p WHERE p.name LIKE ?1")
	List<Product> findByName(String name);
	List<Product> findByCategories(Set<Category> categories);
}
