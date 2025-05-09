package com.sode.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sode.domain.Category;
import com.sode.domain.Condition;
import com.sode.domain.Item;
import com.sode.domain.Price;
import com.sode.domain.Skin;
import com.sode.domain.Weapon;
import com.sode.domain.enums.Exterior;
import com.sode.domain.enums.Quality;
import com.sode.domain.enums.SkinCategory;
import com.sode.repository.CategoryRepository;
import com.sode.repository.ItemRepository;
import com.sode.repository.SkinRepository;

@Configuration
@Profile("testing")
public class TestingProfile implements CommandLineRunner {

	@Autowired
	private SkinRepository skinRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// RESET MONGO BEFORE TEST
		skinRepository.deleteAll();
		categoryRepository.deleteAll();
		itemRepository.deleteAll();
		
		// STORE ONCE FOR REFERENCE --------------------------
		Category c1 = new Category(null, SkinCategory.NORMAL); 
		Category c2 = new Category(null, SkinCategory.STATTRAK); 
		Category c3 = new Category(null, SkinCategory.KNIFE); 
		Category c4 = new Category(null, SkinCategory.GLOVES); 
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		// ---------------------------------------------------

		Skin s1 = new Skin(null, "Gamma Doppler");
		Skin s2 = new Skin(null, "Nightwish");
		Skin s3 = new Skin(null, "Trigger Discipline");
		
		skinRepository.saveAll(Arrays.asList(s1,s2,s3));
		
		Condition con1 = new Condition(Exterior.WELL_WORN, null, Quality.COVERT, s2);
		Condition con2 = new Condition(Exterior.FACTORY_NEW, null, Quality.COVERT, s1);
		Condition con3 = new Condition(Exterior.FIELD_TESTED, null, Quality.RESTRICTED, s3);

		Weapon w1 = new Weapon(null, "AK-47", con1, c1); 
		Weapon w2 = new Weapon(null, "Shadow Daggers", con2, c4); 
		Weapon w3 = new Weapon(null, "Desert Eagle", con3, c2); 
		
		Item i1 = new Item(null, w1.generateName(), new Price(47.98, 3.00) , false);
		Item i2 = new Item(null, w2.generateName(), new Price(10.21, 3.00) , false);
		Item i3 = new Item(null, w3.generateName(), new Price(1.20, 3.00) , false);

		itemRepository.saveAll(Arrays.asList(i1,i2, i3));
		
		}
}
