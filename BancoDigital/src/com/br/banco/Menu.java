package com.br.banco;

import java.util.Scanner;

public class Menu {
	
	public Menu(){
		
	}
	
	public void displayMenu() {
		Banco banco = new Banco();
		int numero = 0;
		int op = 0;
		Scanner myObj = new Scanner(System.in);
		while(op != 6){
			System.out.println("\nInsira a opção que deseja realizar");
			System.out.println("1: Registrar Cliente e conta\n2: Sacar\n3: Depositar\n4: Transferencia\n5: Extrato\n6: Sair");
		
			op = myObj.nextInt();
			switch (op){
				case 1:
					Cliente cliente = new Cliente();
					System.out.println("\nDigite o seu nome");
					cliente.setNome(myObj.next());
					System.out.println("\nDigite o seu cpf");
					cliente.setCPF(myObj.next());
					System.out.println("\nDigite 0 para Poupança e 1 para Corrente");
					int tipoConta = myObj.nextInt();
					if (tipoConta == 0) 
					{
						Conta conta = new ContaPoupanca(cliente);
						banco.addConta(conta);
						
					}
					else if(tipoConta == 1) 
					{
						Conta conta = new ContaCorrente(cliente);
						banco.addConta(conta);
					}
					break;
				case 2:
					//sacar
					banco.listaConta();
					System.out.println("\nSelecione o número da sua conta que deseja sacar");
					numero = myObj.nextInt();
					System.out.println("\nDigite o valor a sacar");
					if (banco.getConta(numero) != null) banco.getConta(numero).sacar(myObj.nextInt());
					break;
				case 3:
					//ordem de depósito
					banco.listaConta();
					System.out.println("\nSelecione o número da sua conta que deseja depositar");
					numero = myObj.nextInt();
					
					System.out.println("\nDigite o valor a depositar");
					if (banco.getConta(numero) != null) banco.getConta(numero).depositar(myObj.nextInt());
					break;
				case 4:
					//ordem de tranferencia
					banco.listaConta();
					System.out.println("\nSelecione o número da sua conta que deseja retirar");
					numero = myObj.nextInt();
					System.out.println("\nSelecione o número da sua conta que deseja transferir");
					int numero2 = myObj.nextInt();
					System.out.println("\nDigite o valor a depositar");
					int valor = myObj.nextInt();
					if (banco.getConta(numero) != null && banco.getConta(numero2) != null) {
						banco.getConta(numero).sacar(valor);
						banco.getConta(numero2).depositar(valor);
					}
					break;
				case 5:
					//ordem de extrato
					banco.listaConta();
					System.out.println("\nSelecione o número da sua conta que deseja depositar");
					numero = myObj.nextInt();
	
					if (banco.getConta(numero) != null) banco.getConta(numero).imprimirExtrato();
					break;
				case 6: 
					System.out.println("\nSaindo do sistema");
					break;
			}
		}
		myObj.close();
	}
}
