package Conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Conta.controller.ContaController;
import Conta.model.ContaCorrente;
import Conta.model.ContaPopanca;
import Conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController conta = new ContaController();

		Scanner sc = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo,limite,valor;
		
		System.out.println("\nCriar contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(conta.gerarNumero(), 123,1,"Felix Hernandes", 1000f, 100.0f);
		conta.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(conta.gerarNumero(), 127,1,"Fernanda Guerreiro", 2500f, 100.0f);
		conta.cadastrar(cc2);
		
		ContaPopanca cp1 = new ContaPopanca(conta.gerarNumero(), 177,2,"Harry Potter", 2580f, 12);
		conta.cadastrar(cp1);
		
		ContaPopanca cp2 = new ContaPopanca(conta.gerarNumero(), 125,2,"Moana do Mar", 8000f, 15);
		conta.cadastrar(cp2);
		
		conta.listarTodas();
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND+
					           "=========================================================");
			System.out.println("                                                         ");
			System.out.println("                  Banco do Brazil com Z                  ");
			System.out.println("                                                         ");
			System.out.println("*********************************************************");
			System.out.println("                                                         ");
			System.out.println("              1 - Criar conta                            ");
			System.out.println("              2 - Listar todas as contas                 ");
			System.out.println("              3 - Buscar conta por numero                ");
			System.out.println("              4 - Atualizar dados da conta               ");
			System.out.println("              5 - Apagar conta                           ");
			System.out.println("              6 - Sacar                                  ");
			System.out.println("              7 - Depositar                              ");
			System.out.println("              8 - Trasnferir valores entre contas        ");
			System.out.println("              9 - sair                                   ");
			System.out.println("                                                         ");
			System.out.println("*********************************************************");
			System.out.println("  Digite a opção deejada:                                ");
			System.out.println("                                                         "+Cores.TEXT_RESET);
			
			try{
				opcao=sc.nextInt();
				
			}catch (InputMismatchException e) {
				System.out.println("Digite apenas valores inteiros");
				sc.nextLine();
				opcao=0;
			}
			
			if ( opcao==9) {
				
				System.out.println(Cores.TEXT_WHITE_BOLD+"Banco do Brazil com Z - O seu futuro começa aqui");
				sc.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta\n\n");
				
				System.out.println("Digite o Número da agencia");
				agencia=sc.nextInt();
				System.out.println("Digite o Nome do titular");
				sc.skip("\\R?");
				titular = sc.nextLine();
				
				do {
					System.out.println("Digite o tipo de conta (1-Cc ou 2-Cp: ");
					tipo=sc.nextInt();
				}while(tipo<1 && tipo>2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo=sc.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (R$): ");
					limite = sc.nextFloat();
					conta.cadastrar(new ContaCorrente(conta.gerarNumero(),agencia, tipo, titular, saldo, limite));	
				}
				case 2 ->{
					System.out.println("Digite o dia do anversário da conta: ");
					aniversario= sc.nextInt();
					conta.cadastrar(new ContaPopanca(conta.gerarNumero(),agencia, tipo, titular, saldo, aniversario));	
				
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				conta.listarTodas();
				keyPress();

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número das conta: ");
				numero=sc.nextInt();
				conta.procurarPorNumero(numero);
				
				keyPress();

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero=sc.nextInt();
				
				if(conta.buscarCollection(numero)!= null) {
					
					System.out.println("Digite o Número da agencia");
					agencia=sc.nextInt();
					System.out.println("Digite o Nome do titular");
					sc.skip("\\R?");
					titular = sc.nextLine();
					
					System.out.println("Digite o saldo da conta (R$): ");
					saldo=sc.nextFloat();
					
					tipo = conta.retornaTipo(numero);
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$): ");
						limite = sc.nextFloat();
						conta.atualizar(new ContaCorrente(numero,agencia, tipo, titular, saldo, limite));	
					}
					case 2 ->{
						System.out.println("Digite o dia do anversário da conta: ");
						aniversario= sc.nextInt();
						conta.atualizar(new ContaPopanca(numero,agencia, tipo, titular, saldo, aniversario));	
					
						}
					default -> {
					System.out.println("Tipo de conta inválido!");
					}
					}
					
				}else System.out.println("Conta não encontrada!");
				
				keyPress();

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta para deletar");
				numero=sc.nextInt();
				
				conta.deletar(numero);
				
				keyPress();

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				System.out.println("\nDigite o número da conta ");
				numero=sc.nextInt();
				
				do {
					System.out.println("\n Digite o valor do saque:");
					valor=sc.nextFloat();
				}while(valor<=0);
					conta.sacar(numero, valor);
					keyPress();

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				System.out.println("Digite o número da conta:");
				numero=sc.nextInt();
				
				do {
					System.out.println("\n Digite a ser depositado:");
					valor=sc.nextFloat();
				}while(valor<=0);
				conta.depositar(numero,valor);
				
				
				keyPress();

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
				
				System.out.println("\nDigite o número da conta de Origem");
				numero=sc.nextInt();
				System.out.println("\nDigite o número da conta de destino");
				numeroDestino=sc.nextInt();
				
				do {
					System.out.println("\n Digite o valor da transferência:");
					valor=sc.nextFloat();
				}while(valor<=0);
				conta.transferir(numero, numeroDestino, valor);
				
				keyPress();

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();

				break;
				
			}

		}		
	}
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
	

}
