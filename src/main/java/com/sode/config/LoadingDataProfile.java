package com.sode.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import com.sode.domain.Case;
import com.sode.domain.Condition;
import com.sode.domain.Price;
import com.sode.domain.Weapon;
import com.sode.domain.enums.Categories;
import com.sode.domain.enums.Qualities;
import com.sode.domain.enums.Weapons;
import com.sode.repository.CaseRepository;
import com.sode.repository.WeaponRepository;
import com.sode.utils.Currency;
import com.sode.utils.Data;

@Configuration
@Profile("SkinCaseLoader")
public class LoadingDataProfile implements CommandLineRunner {

	private final static double MARKET_FEE = 3.15;

	@Autowired
	private CaseRepository caseRepository; 

	@Autowired 
	private WeaponRepository weaponRepository;

	@Override
	public void run(String... args) throws Exception {
		
		weaponRepository.deleteAll();
		caseRepository.deleteAll();

		List<String[]> file = Data.loadCSV(new ClassPathResource("data/marketplace_data.csv"));

		Case ca = null;

		for (int row = 1; row < file.size(); row++) {

			String gun = file.get(row)[0].replace("-", "_").replace(" ", "_").toUpperCase();
			String skin = file.get(row)[1];
			String quality = file.get(row)[2].replace("-", "_").toUpperCase();
			String caseName = file.get(row)[4];

			try {

				if (ca == null || !caseName.equals(ca.getName())) {

					if (ca != null) {
						caseRepository.save(ca);
					}

					ca = new Case(null, caseName);
					Price p = new Price(Currency.generateRandomPrice(1.0, 100.0), MARKET_FEE);
					ca.setPrice(p);

				}

				Condition c = new Condition(null, null, Qualities.valueOf(quality), skin);
				Weapon w = new Weapon(null, Weapons.valueOf(gun), c, Categories.NORMAL, false);

				ca.getItens().add(w);
				weaponRepository.save(w);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(row + " " + gun + " " + skin + " " + quality);
			}

			caseRepository.save(ca);
		}
	}
}
