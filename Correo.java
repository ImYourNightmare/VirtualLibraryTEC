package Control;

public class Correo {
	String usuario,contrase�a,destino,asunto,cuerpomensaje;
	
	public Correo(String usuario,String contrase�a,String destino,String asunto,String cuerpomensaje) {
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.destino=destino;
		this.asunto=asunto;
		this.cuerpomensaje=cuerpomensaje;
		}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpomensaje() {
		return cuerpomensaje;
	}

	public void setCuerpomensaje(String cuerpomensaje) {
		this.cuerpomensaje = cuerpomensaje;
	}
	
}
