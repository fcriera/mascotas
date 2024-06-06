package com.frc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.frc.model.Mascota;

@SpringBootTest
class MascotasApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testMascotas() {
		Mascota mascota = new Mascota();
		mascota.setName("Popi");
		Assertions.assertEquals("Popi", mascota.getName());
	}

}
