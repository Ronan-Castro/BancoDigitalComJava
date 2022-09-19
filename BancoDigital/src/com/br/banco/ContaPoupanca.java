package com.br.banco;

public class ContaPoupanca extends Conta{
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	public void imprimirExtrato() {
		System.out.println("==== Extrato Conta Corrente ====");
		imprimeInfos();
		System.out.println("==== ====================== ====\n");
	}
}