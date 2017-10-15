package domain;

import java.io.Serializable;

public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double saldo;

	private String numero;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
