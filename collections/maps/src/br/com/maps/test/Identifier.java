package br.com.maps.test;

import java.util.Random;

public abstract class Identifier {
	protected String id = generateId();
	
	private String generateId() {
		Random random = new Random();
		String generatedId = "";

		for (int i = 0; i < 17; i++) {
			if (i == 5 || i == 11) {
				generatedId += "-";
				continue;
			}
			// True se for uma letra, False se for um número
			if (random.nextBoolean()) {
				Character letter;

				// True se for uma letra minuscula, False se for uma letra maiscula
				if (random.nextBoolean()) {
					letter = (char) random.nextInt(97, 122);
				} else 
					letter = (char) random.nextInt(65, 90);

				generatedId += letter.toString();
			} else 
				generatedId += random.nextInt(9);
			
		}

		return generatedId;
	}
	
	public String getId() {
		return id;
	}
}
