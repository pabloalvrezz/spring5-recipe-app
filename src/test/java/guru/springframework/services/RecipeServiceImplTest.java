package guru.springframework.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		HashSet recipesDate = new HashSet(); 
		recipesDate.add(recipe);
		
		when(recipeServiceImpl.getRecipes()).thenReturn(recipesDate);
		
		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		
		assertEquals(recipes.size(), 1);
	}

}
