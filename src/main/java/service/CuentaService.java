package service;

import java.io.Serializable;

import javax.jws.WebService;

import expose.ICuentaService;

@WebService(endpointInterface = "expose.ICuentaService")
public class CuentaService implements ICuentaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Long crearCuenta(Usuario usuario) {
		return 1L;
	}

	@Override
	public Boolean debitarCuenta(Integer cuenta, Double monto) {
		return true;
	}

	@Override
	public Boolean aumentarCuenta(Integer cuenta, Double monto) {
		return true;
	}

}
