package TratamentoDeErro;

public class DadoInvalidoException extends Exception {
	
	public DadoInvalidoException(String mensagem){
		super(mensagem);
	}
	
	private static final long serialVersionUID = 1L;
}
