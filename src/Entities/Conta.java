package Entities;

import javax.swing.JOptionPane;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    
    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    public void sacar(double valor){
        this.saldo -= valor;
    }
    
    public void depositar(double valor){
        this.saldo += valor;
    }
    
    public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
    }
    public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
        
	protected void imprimirInfosComuns(){
            JOptionPane.showMessageDialog(null, "Titular: " + this.cliente.getNome() 
                +"\n"+"Agencia: "+ this.agencia
                +"\n"+"Numero: "+ this.numero
                +"\n"+"Saldo: "+ String.format("%.2f", this.saldo), "              EXTRATO", 1, null);
              
	}
}
