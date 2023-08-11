package Conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Conta.model.ContaCorrente;
import Conta.model.ContaPopanca;
import Conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		
		
		ContaCorrente cc1 = new ContaCorrente(2,232,1,"Bramante", 1500.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.depositar(780.0f);
		cc1.visualizar();
		
		ContaPopanca cp1 = new ContaPopanca(3, 123, 2, "Maria dos Santos", 1000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.depositar(780.0f);
		cp1.visualizar();

		
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
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				keyPress();

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				keyPress();

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
				keyPress();

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				keyPress();

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				keyPress();

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				keyPress();

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
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
