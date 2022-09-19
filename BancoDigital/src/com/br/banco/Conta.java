package com.br.banco;

public abstract class Conta implements InterfaceConta{

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected static final int AGENCIA = 1;
	private static int SEQUENCIAL = 1;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	@Override
	public void sacar(double valor) {
		// TODO Auto-generated method stub
		if(valor <= this.saldo) {
				this.saldo -= valor;
		System.out.println("\nVocê sacou $" + valor +  " da conta " + this.numero + " do cliente " + this.cliente.getNome());
		}else 
			System.err.println("SALDO INSUFICIENTE");
		
	}

	@Override
	public void depositar(double valor) {
		// TODO Auto-generated method stub
		this.saldo = valor;
		System.out.println("\nVocê depositou $" + valor +  " na conta " + this.numero + " do cliente " + this.cliente.getNome());
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= this.saldo)
		{
		this.sacar(valor);
		
		contaDestino.depositar(valor);
		}else
			System.err.println("SALDO INSUFICIENTE");
		
	}
	
	
	protected void imprimeInfos() {
		System.out.println("Titular: " + this.cliente.getNome());
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Numero: " + this.numero);
		System.out.printf("Saldo: %.2f\n", this.saldo);
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


}

