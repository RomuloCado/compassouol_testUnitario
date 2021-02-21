package com.compassouol.produtos.config.validacao;


//Classe que retorna os campos onde foram encontrados erros de validação 
public class ErroDeValidacaoDto {
	
	private String campo;
	private String erro;
	
	
	public ErroDeValidacaoDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getErro() {
		return erro;
	}
	
	
}
