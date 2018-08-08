package parqueadero.exception;

public class ParqueaderoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    private final String descripion;

	public ParqueaderoException(String descripion) {
		super();
		this.descripion = descripion;
	}

	public String getDescripion() {
		return descripion;
	}
        	
}
