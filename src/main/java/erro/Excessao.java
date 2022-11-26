package erro;

public class Excessao  extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public Excessao(String msg, Integer codigo) {
		super(msg);
		this.codigo=codigo;
		
	}
	
	public Integer getCodigo() {
		return codigo;
	}

}
