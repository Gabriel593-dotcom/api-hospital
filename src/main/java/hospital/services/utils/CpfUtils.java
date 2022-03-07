package hospital.services.utils;

public class CpfUtils {

	public static boolean validaCpf(String cpf) {
		//fonte: https://dicasdeprogramacao.com.br/algoritmo-para-validar-cpf/
		
		String cpfFormated = cpf.replaceAll("[. -]", "");

		if (cpfFormated.length() == 11) {

			String firstNumber = cpfFormated.substring(0, 1);
			String cpfValidation = cpfFormated.replaceAll(firstNumber, "");

			if (!cpfValidation.isBlank()) {
				Integer num1 = Integer.parseInt(cpfFormated.substring(0, 1));
				Integer num2 = Integer.parseInt(cpfFormated.substring(1, 2));
				Integer num3 = Integer.parseInt(cpfFormated.substring(2, 3));
				Integer num4 = Integer.parseInt(cpfFormated.substring(3, 4));
				Integer num5 = Integer.parseInt(cpfFormated.substring(4, 5));
				Integer num6 = Integer.parseInt(cpfFormated.substring(5, 6));
				Integer num7 = Integer.parseInt(cpfFormated.substring(6, 7));
				Integer num8 = Integer.parseInt(cpfFormated.substring(7, 8));
				Integer num9 = Integer.parseInt(cpfFormated.substring(8, 9));
				Integer num10 = Integer.parseInt(cpfFormated.substring(9, 10));
				Integer num11 = Integer.parseInt(cpfFormated.substring(10, 11));

				Integer validationDigit10 = 0;
				Integer validationDigit11 = 0;

				validationDigit10 = ((num1 * 10) + (num2 * 9) + (num3 * 8) + (num4 * 7) + (num5 * 6) + (num6 * 5)
						+ (num7 * 4) + (num8 * 3) + (num9 * 2)) * 10;

				if (validationDigit10 % 11 == num10) {

					validationDigit11 = ((num1 * 11) + (num2 * 10) + (num3 * 9) + (num4 * 8) + (num5 * 7) + (num6 * 6)
							+ (num7 * 5) + (num8 * 4) + (num9 * 3) + (num10 * 2)) * 10;

					if (validationDigit11 % 11 == num11) {
						return true;

					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
