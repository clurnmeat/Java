package com.devmountain.RadRecipeMaker.repositories;

import com.devmountain.RadRecipeMaker.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
