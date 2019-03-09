package projeto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class RomanNumberComponent {
	
	/**
	 * Aux variable to key roman numbers.
	 */
	private static final Map<Integer, String> numbersBaseToRoman = new HashMap<Integer, String>();
	private static final Map<String, Integer> romanBaseToNumbers;
	
	static {
		numbersBaseToRoman.put(1, "I");
		numbersBaseToRoman.put(4, "IV");
		numbersBaseToRoman.put(5, "V");
		numbersBaseToRoman.put(9, "IX");
		numbersBaseToRoman.put(10, "X");
		numbersBaseToRoman.put(40, "XL");
		numbersBaseToRoman.put(50, "L");
		numbersBaseToRoman.put(90, "XC");
		numbersBaseToRoman.put(100, "C");
		numbersBaseToRoman.put(400, "CD");
		numbersBaseToRoman.put(500, "D");
		numbersBaseToRoman.put(900, "CM");
		numbersBaseToRoman.put(1000, "M");
		
		romanBaseToNumbers = numbersBaseToRoman.entrySet().stream()
							.collect(Collectors.toMap(Entry::getValue, Entry::getKey));
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

		String romanReturn =  thousand(number) 
							+ century(number) 
							+ tens(number)
							+ unit(number);

		return romanReturn;
	}
	
	public Integer convertToNumber(String number) {
		int result = 0;
		for (int positionChatAt = 0; positionChatAt < number.length(); positionChatAt++) {
			int characterValue = romanBaseToNumbers.get(String.valueOf(number.charAt(positionChatAt)));
			
			if (positionChatAt + 1 < number.length()) {
				int characterValue2 = romanBaseToNumbers.get(String.valueOf(number.charAt(positionChatAt + 1)));

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

	/**
	 * Return unit part in roman of a number
	 * @param number
	 * @return roman value
	 */
	private String unit(Integer number) {
		Integer units = ((number % 100) % 10);

		return getRomanToMapOrRepeat(units, units, "X");
	}

	/**
	 * Return tens part in roman of a number
	 * @param number
	 * @return roman value
	 */
	private String tens(Integer number) {
		Integer quantidadeDeDezenas = (number % 100) / 10;
		Integer dezena = quantidadeDeDezenas * 10;

		return getRomanToMapOrRepeat(dezena, quantidadeDeDezenas, "X");
	}

	/**
	 * Return century part in roman of a number
	 * @param number
	 * @return roman value
	 */
	private String century(Integer number) {
		Integer qtdCenturys = (number % 1000) / 100;
		Integer centena = qtdCenturys * 100;

		return getRomanToMapOrRepeat(centena, qtdCenturys, "C");
	}

	/**
	 * Return thousand part in roman of a number
	 * @param number
	 * @return roman value
	 */
	private String thousand(Integer number) {
		Integer qtdThousand = (number % 10000) / 1000;
		Integer thousand = qtdThousand * 1000;

		return getRomanToMapOrRepeat(thousand, qtdThousand, "M");
	}

	/**
	 * Return roman number from {@link RomanNumberComponent#numbersBaseToRoman} or repeat character of param
	 * @param baseRomanOnMap
	 * @param repeats
	 * @param letter
	 * @return roman value
	 */
	private String getRomanToMapOrRepeat(Integer baseRomanOnMap, Integer repeats, String letter) {
		if (numbersBaseToRoman.containsKey(baseRomanOnMap)) {
			return numbersBaseToRoman.get(baseRomanOnMap);
		}

		return repeat(repeats, letter);
	}

	/**
	 * Repeat character of param N times.
	 * @param repeats
	 * @param character
	 * @return character param concats N times
	 */
	public String repeat(Integer repeats, String character) {
		if (repeats > 3) {
			return "";
		}

		return String.join("", Collections.nCopies(repeats, character));
	}
	
}
