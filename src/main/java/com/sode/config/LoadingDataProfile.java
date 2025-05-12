package com.sode.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import com.sode.domain.Condition;
import com.sode.domain.Item;
import com.sode.domain.Weapon;
import com.sode.domain.enums.Categories;
import com.sode.domain.enums.Qualities;
import com.sode.domain.enums.Weapons;
import com.sode.repository.ItemRepository;
import com.sode.utils.Data;

@Configuration
@Profile("Loader")
public class LoadingDataProfile implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {

		// IMPLEMENTS KNIVES SKINS...

		itemRepository.deleteAll();

		List<String[]> file = Data.loadCSV(new ClassPathResource("data/guns.csv"));

		for (int row = 1; row < file.size(); row++) {

			String gun = file.get(row)[0]
					.replace("-", "_")
					.replace(" ", "_")
					.toUpperCase();
			String skin = file.get(row)[1];
			String quality = file.get(row)[2]
					.replace("-", "_")
					.toUpperCase();

			Condition c = new Condition(null, null, Qualities.valueOf(quality), skin);
			Weapon w = new Weapon(null, Weapons.valueOf(gun) , c, Categories.NORMAL);

			Item i = new Item(null, w, null, false);
			
			itemRepository.save(i);
		}

	}

}
