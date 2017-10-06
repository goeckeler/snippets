package nerda;

import java.util.HashSet;
import java.util.Set;

/**
 * DER CODE BESTEHT AUS 9 UNTERSCHIEDLICHEN ZIFFERN. VON RECHTS NACH LINKS
 * GELESEN IST DIE KOMBINATION EINE QUADRATZAHL. VON LINKS NACH RECHTS GELESEN
 * IST SIE DIE GRÖSSTE ZAHL, DIE DIE ERSTEN BEIDEN BEDINGUNGEN ERFÜLLT.
 */
public class Nerda {
	public static void main(String[] args) {
		for (long number = 987654321; number >= 102345678; --number) {
			if (consistsOfAllDigits(number) && isSquareNumber(number)) {
				System.out.println("Try " + number);
				System.exit(9);
			}
		}

		System.out.println("No solution found.");
	}

	private static boolean isSquareNumber(long number) {
		long reverseNumber = reverse(number);
		long root = Math.round(Math.ceil(Math.sqrt(reverseNumber)));
		return root * root == reverseNumber;
	}

	private static long reverse(long number) {
		StringBuilder string = new StringBuilder(Long.toString(number)).reverse();
		return Long.valueOf(string.toString());
	}

	private static boolean consistsOfAllDigits(long number) {
		Set<Integer> digits = new HashSet<>();
		Long.toString(number).chars().forEach(c -> digits.add(Character.getNumericValue(c)));
		return digits.size() == 9;
	}
}
