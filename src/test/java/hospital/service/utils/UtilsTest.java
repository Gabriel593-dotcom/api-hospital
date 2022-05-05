package hospital.service.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hospital.services.utils.Utils;

public class UtilsTest {

	@Test
	@DisplayName("deve validar cpf informado")
	public void verificaSeCpfEValido() {
		Assertions.assertTrue(Utils.validaCpf("38051291069"));
	}

	@Test
	@DisplayName("NÃO deve validar cpf informado por estar vazio")
	public void verificaSeCpfEInvalidoVazio() {
		Assertions.assertFalse(Utils.validaCpf(""));
	}

	@Test
	@DisplayName("NÃO deve validar cpf informado por sequencia incongruente")
	public void verificaSeCpfEInvalidoIngongruencia() {
		Assertions.assertFalse(Utils.validaCpf("12435690914"));
	}

	@Test
	@DisplayName("NÃO deve validar cpf por ser composto de uma sequencia de apenas um número")
	public void verificaSeCpfEInvalidoPorSequenciaDeUmNumeroApenas() {
		Assertions.assertFalse(Utils.validaCpf("11111111111"));
	}

	@Test
	@DisplayName("Deve validar data informada")
	public void verificaSeDataEValida() {
		Assertions.assertTrue(Utils.validaData("31/12/2023 10:30"));
	}
	
	@Test
	@DisplayName("Deve validar data informada pois 2024 é ano bissexto")
	public void verificaSeDataEValidaAnoBissexto() {
		Assertions.assertTrue(Utils.validaData("29/02/2024 10:30"));
	}
	
	@Test
	@DisplayName("NÃO Deve validar data informada pois 2023 não é ano bissexto")
	public void verificaSeDataEInvalidaAnoBissexto() {
		Assertions.assertFalse(Utils.validaData("29/02/2023 10:30"));
	}	
	
	@Test
	@DisplayName("NÃO Deve validar data informada pois Abril não tem dia 31")
	public void naoVerificaDataAbrilTrintaEUm() {
		Assertions.assertFalse(Utils.validaData("31/04/2023 10:30"));
	}
	
	@Test
	@DisplayName("NÃO Deve validar data informada pois feveiro não tem dia 30 nem 31")
	public void naoVerificaDataFevereiroTrintaETrintaEUm() {
		Assertions.assertFalse(Utils.validaData("30/02/2023 10:30"));
		Assertions.assertFalse(Utils.validaData("31/02/2023 10:30"));	
	}
	
	@Test
	@DisplayName("NÃO Deve validar data informada pois está no passado")
	public void naoVerificaDataPassado() {
		Assertions.assertFalse(Utils.validaData("30/04/2022 10:30"));
	}
}
