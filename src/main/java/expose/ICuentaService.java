package expose;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import service.Usuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface ICuentaService {

	@WebMethod
	Long crearCuenta(Usuario usuario);

	@WebMethod
	Boolean debitarCuenta(Integer cuenta, Double monto);

	@WebMethod
	Boolean aumentarCuenta(Integer cuenta, Double monto);

}
