package hospital.services.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	private static final String FEVEREIRO = "02";
	private static final String ABRIL = "04";
	private static final String JUNHO = "06";
	private static final String SETEMBRO = "09";
	private static final String NOVEMBRO = "11";
	private static String mensagemErroValidacaoDaData = "";

	public static String getMensagemErroValidacaoDaData() {
		return mensagemErroValidacaoDaData;
	}

	public static void setMensagemErroValidacaoDaData(String mensagemErroValidacaoDaData) {
		Utils.mensagemErroValidacaoDaData = mensagemErroValidacaoDaData;
	}

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

	public static boolean validaData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		boolean validacao = true;
		GregorianCalendar anoBissexto = new GregorianCalendar();
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);

		try {
			if (!data.matches(
					"^([0-2][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/([0-9]){4} ([0-2][0-3]|[2][0-3]):[0-5][0-9]$")) {
				mensagemErroValidacaoDaData = "Formato de data está incorreto. Tente no padrão (dd/MM/yyyy HH:mm)";
				validacao = false;
			}

			Date dataAtual = new Date();
			Date dataConsulta = sdf.parse(data);

			if (dataConsulta.before(dataAtual)) {
				if (mensagemErroValidacaoDaData == "") {
					mensagemErroValidacaoDaData = "A data informada não pode ser anterior a data atual.";
				}
				validacao = false;
			}

			if (dia.equals("31")
					&& (mes.equals(ABRIL) || mes.equals(JUNHO) || mes.equals(SETEMBRO) || mes.equals(NOVEMBRO))) {
				if (mensagemErroValidacaoDaData == "") {
					mensagemErroValidacaoDaData = "Não tem o dia 31 no mês " + mes;
				}
				validacao = false;
			}

			if (dia.equals("29") && mes.equals(FEVEREIRO) && !anoBissexto.isLeapYear(Integer.parseInt(ano))) {
				if (mensagemErroValidacaoDaData == "") {
					mensagemErroValidacaoDaData = ano + " não é ano bissexto.";
				}
				validacao = false;
			}

			if ((dia.equals("30") || dia.equals("31")) && mes.equals(FEVEREIRO)) {
				if (mensagemErroValidacaoDaData == "") {
					mensagemErroValidacaoDaData = "no mês " + mes + " não temos os dias 30 e 31.";
				}
				validacao = false;
			}

			return validacao;

		} catch (ParseException e) {
			return false;
		}
	}
}
