package com.br.lojix.model.enums;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"),
	USER(1, "ROLE_CLIENTE");
	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (code.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

}
