package br.com.cod3r.cm.modelo;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;

class CampoTeste {

	private Campo campo; 
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3 ,3);
	}
	
	@Test
	void testeVizinhoReal() {
		Campo vizinho = new Campo(2 ,3); 
		boolean resultado = campo.adicionarVizinho(vizinho); 
		
		assertTrue(resultado);
	}
	
	@Test
	void testeValorMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeValorAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado()); 
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar(); 
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

}