package Conta.model;

import Conta.util.Cores;

public class ContaCorrente extends Conta{
	
	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if(getSaldo()+getLimite()<valor) {
			System.out.println(Cores.TEXT_RED_BOLD+"Saldo insuficiente"+Cores.TEXT_RESET);
			return false;
		}else {
			this.setSaldo(getSaldo()-valor);
			return true;
		}
	}
	
	@Override
	public void visualizar(){
		super.visualizar();
		System.out.println("Limite de crédito"+this.limite);
	}
}
