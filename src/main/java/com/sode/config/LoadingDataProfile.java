package com.sode.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import com.sode.CsCaseSimulatorApplication;
import com.sode.domain.Case;
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

	private final CsCaseSimulatorApplication csCaseSimulatorApplication;

	@Autowired
	private ItemRepository itemRepository;

	LoadingDataProfile(CsCaseSimulatorApplication csCaseSimulatorApplication) {
		this.csCaseSimulatorApplication = csCaseSimulatorApplication;
	}

	@Override
	public void run(String... args) throws Exception {

		// IMPLEMENTS KNIVES SKINS...

		itemRepository.deleteAll();

		List<String[]> file = Data.loadCSV(new ClassPathResource("data/marketplace_data.csv"));

		Case ca = null;
		Item itemCase = null;

		for (int row = 1; row < file.size(); row++) {

			String gun = file.get(row)[0].replace("-", "_").replace(" ", "_").toUpperCase();
			String skin = file.get(row)[1];
			String quality = file.get(row)[2].replace("-", "_").toUpperCase();
			String caseName = file.get(row)[4];

			try {

				if (ca == null || !caseName.equals(ca.getName())) {

					if (itemCase != null) {
						itemRepository.save(itemCase);
					}

					ca = new Case(null, caseName);
					itemCase = new Item(null, ca, null, true);

				}

				Condition c = new Condition(null, null, Qualities.valueOf(quality), skin);
				Weapon w = new Weapon(null, Weapons.valueOf(gun), c, Categories.NORMAL);

				itemCase.getItens().add(w);

				itemRepository.save(new Item(null, w, null, false));

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(row + " " + gun + " " + skin + " " + quality);
				// TODO: handle exception
			}

			itemRepository.save(itemCase);
		}
	}
}
