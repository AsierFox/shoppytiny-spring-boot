package com.shoppytiny.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.shoppytiny.domain.Category;

@Service
@Validated
public interface CategoryService {
    List<Category> findAll();
    Category getCategoryByName(String name);
}
