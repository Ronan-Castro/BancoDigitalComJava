package com.br.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas;
	
	public Banco() {
		this.contas = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void listaClientes() {
		for(Conta conta: contas) {
			System.out.println(conta.cliente.getNome());
		}
		System.out.println();
	}
	public void listaConta() {
		for(Conta conta: contas) {
			System.out.println("Numero: " + conta.numero + " Cliente: " + conta.cliente.getNome());
		}
		System.out.println();
	}
	public void addConta(Conta conta) {
		contas.add(conta);
	}
	
	public Conta getConta(int numero) {
		for(Conta conta: contas) {
			if(numero == conta.numero) {
				return conta;
			}
		}
		return null;
		
	}
}
