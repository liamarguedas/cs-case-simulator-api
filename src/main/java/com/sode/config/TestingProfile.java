package com.sode.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sode.domain.Condition;
import com.sode.domain.Item;
import com.sode.domain.Price;
import com.sode.domain.Weapon;
import com.sode.domain.enums.Exteriors;
import com.sode.domain.enums.Qualities;
import com.sode.domain.enums.Weapons;
import com.sode.domain.enums.Categories;
import com.sode.repository.ItemRepository;

@Configuration
@Profile("testing")
public class TestingProfile implements CommandLineRunner {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// RESET MONGO BEFORE TEST
		itemRepository.deleteAll();
		
		Condition con1 = new Condition(Exteriors.WELL_WORN, null, Qualities.COVERT, "Nightwish");
		Condition con2 = new Condition(Exteriors.FACTORY_NEW, null, Qualities.COVERT, "Gamma Doppler");
		Condition con3 = new Condition(Exteriors.FIELD_TESTED, null, Qualities.RESTRICTED, "Trigger Discipline");

		Weapon w1 = new Weapon(null, Weapons.AK_47, con1, Categories.NORMAL ); 
		Weapon w2 = new Weapon(null, Weapons.SHADOW_DAGGERS, con2, Categories.GLOVES); 
		Weapon w3 = new Weapon(null, Weapons.DESERT_EAGLE, con3, Categories.STATTRAK); 
		
		Item i1 = new Item(null, w1, new Price(47.98, 3.00) , false);
		Item i2 = new Item(null, w2, new Price(10.21, 3.00) , false);
		Item i3 = new Item(null, w3, new Price(1.20, 3.00) , false);

		itemRepository.saveAll(Arrays.asList(i1,i2, i3));
		
		}
}
