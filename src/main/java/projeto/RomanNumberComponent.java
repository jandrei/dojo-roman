package projeto;

public class RomanNumberComponent {

	enum Numeral {
		M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

		Integer number;

		Numeral(Integer number) {
			this.number = number;
		}
	}

	/**
	 * Convert any number positive between 1 and 3000 in to roman value
	 * 
	 * @exception IllegalArgumentException
	 * @param number
	 * @return roman value
	 */
	public String convertToRoman(Integer number) {
		if (number == null || number <= 0 || number > 3000) {
			throw new IllegalArgumentException("Only numbers between 1 and 3000 are accepted.");
		}

		String romanReturn = "";

		for (Numeral numeral : Numeral.values()) {
			while (number >= numeral.number) {
				number -= numeral.number;
				romanReturn += numeral.toString();
			}
		}

		return romanReturn;
	}

	public Integer convertToNumber(String number) {
		if (number == null || number.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid parameter for conversion, must be a valid roman numeral.");
		}
		number = number.toUpperCase().trim();

		String[] characters = number.split("");
		for (String character : characters) {
			if (Numeral.valueOf(character) == null) {
				throw new IllegalArgumentException(String.format("Invalid roman letter \"%s\".", character));
			}
		}

		int result = 0;
		for (int positionChatAt = 0; positionChatAt < characters.length; positionChatAt++) {
			Integer characterValue = Numeral.valueOf(characters[positionChatAt]).number;

			if (positionChatAt + 1 < number.length()) {
				Integer characterValue2 = Numeral.valueOf(characters[positionChatAt + 1]).number;

				if (characterValue >= characterValue2) {
					result += characterValue;
				} else {
					result += characterValue2 - characterValue;
					positionChatAt++;
				}
			} else {
				result += characterValue;
				positionChatAt++;
			}
		}

		String verification = this.convertToRoman(result);
		if (!verification.equals(number)) {
			throw new IllegalArgumentException(String.format("Invalid roman number."));
		}

		return result;
	}

}
