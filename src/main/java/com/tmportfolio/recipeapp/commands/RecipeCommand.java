package com.tmportfolio.recipeapp.commands;

import com.tmportfolio.recipeapp.model.Difficulty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    @Min(1)
    private Integer prepTime;
    @Min(1)
    private Integer cookTime;
    @Min(1)
    private Integer servings;
    private String source;
    private Byte[] image;
    @URL
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();

}