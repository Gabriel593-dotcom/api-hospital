package hospital.service.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hospital.services.utils.CpfUtils;

public class CpfUtilsTest {

	@Test
	@DisplayName("deve validar cpf informado")
	public void verificaSeCpfEValido() {
		Assertions.assertTrue(CpfUtils.validaCpf("38051291069"));
	}

	@Test
	@DisplayName("NÃO deve validar cpf informado por estar vazio")
	public void verificaSeCpfEInvalidoVazio() {
		Assertions.assertFalse(CpfUtils.validaCpf(""));
	}

	@Test
	@DisplayName("NÃO deve validar cpf informado por sequencia incongruente")
	public void verificaSeCpfEInvalidoIngongruencia() {	
		Assertions.assertFalse(CpfUtils.validaCpf("12435690914"));
	}
	
	@Test
	@DisplayName("NÃO deve validar cpf por ser composto de uma sequencia de apenas um número")
	public void verificaSeCpfEInvalidoPorSequenciaDeUmNumeroApenas() {
		Assertions.assertFalse(CpfUtils.validaCpf("11111111111"));
	}

}
