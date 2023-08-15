package Conta.model;

public class ContaPopanca extends Conta {
	
	private int aniversario;

	public ContaPopanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar(){
		super.visualizar();
		System.out.println("Aniversário da conta: "+this.aniversario);
	}

}
