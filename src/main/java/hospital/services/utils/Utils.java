package hospital.services.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hospital.services.exceptions.DataException;

public class Utils {

	public static boolean validaCpf(String cpf) {
		// fonte: https://dicasdeprogramacao.com.br/algoritmo-para-validar-cpf/

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

	public static Date montaData(String data) throws ParseException {
		//TODO arrumar esse método
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		if (data.matches(
				"^((0[1-9]|[12]\\d)\\/(0[1-9]|1[0-2])|30\\/(0[13-9]|1[0-2])|31\\/(0[13578]|1[02])) \\/\\d{4}$")) {
			throw new DataException("Data incorreta. Digitar no formato dd/MM/yyyy HH:mm");
		}

		return sdf.parse(data);
	}
}
