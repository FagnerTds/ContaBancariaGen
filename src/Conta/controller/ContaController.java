package Conta.controller;

import java.util.ArrayList;

import Conta.model.Conta;
import Conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta>listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarCollection(numero);
			
			if (conta != null)
				conta.visualizar();
			else System.out.println("\nConta número: "+numero+" não foi encontrada. ");
	}

	@Override
	public void listarTodas() {
		for(var conta: listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n conta número "+ conta.getNumero()+" Foi cadastrada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A conta número "+ conta.getNumero()+" foi atualizada com sucesso!");
		}
		else {
			System.out.println("A conta número: "+conta.getNumero()+" não foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta)== true)
				System.out.println("\nA conta numero "+ numero+ " foi deletada com sucesso!");
		}else System.out.println("\nA conta numero "+ numero+ " não foi encontrada!");

		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarCollection(numero);
		if (conta != null) {
		
		if (conta.sacar(valor)==true) {
			System.out.println("\n o saque na conta "+ numero+ " foi efetuado com sucesso ");
		}
		}else System.out.println("A conta "+numero+" não foi encontrada");
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarCollection(numero);
		if (conta!=null) {
			conta.depositar(valor);
			System.out.println("\nO deposito na conta "+numero+" foi efetuado com sucesso");
		}else System.out.println("\nA conta "+numero+" não foi econtrada ou não é uma conta corrente");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarCollection(numeroOrigem);
		var contaDestino = buscarCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor)== true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso");	
			}
		}else System.out.println("\nA cont de origem e ou destino não foram encontradas");
		
		
		
		
	}
	
	public int gerarNumero(){	
		return ++ numero;
	}
	
	public Conta buscarCollection(int numero) {
		for(var conta: listaContas) {
			if (conta.getNumero()== numero) {
				return conta;
			}
		}
		return null;
	}
	
	public int retornaTipo(int numero) {
		for(var conta : listaContas) {
			if (conta.getNumero()== numero) {
			return conta.getTipo();
			}
		}
		return 0;
	}

}
