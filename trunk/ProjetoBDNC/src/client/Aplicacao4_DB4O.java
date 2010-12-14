package client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Cidade;
import model.Telefone;
import model.Usuario;
import DAOFactory.DAOFactory;
import DAOInterface.DAOcidadeIF;
import DAOInterface.DAOtelefoneIF;
import DAOInterface.DAOusuarioIF;

public class Aplicacao4_DB4O {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Início de marcação de tempo
		long temp = System.currentTimeMillis();
		
		//Consulta 1: navegacao entre colecoes---------------------------------------------
		DAOtelefoneIF DAOtel = DAOFactory.getInstance("db4o").createTelefoneDAO();
		DAOtel.begin();

		System.out.println("\n\nRealizando consulta 1...");
		long tempConsulta1 = System.currentTimeMillis();
		
		List<Telefone> resultado = (List<Telefone>) DAOtel.findByUsuario(40);
		
		System.out.println("\nTelefone(s) resgatado(s): ");
		Iterator it = resultado.iterator();
		while (it.hasNext()) {
			Telefone tel = (Telefone)it.next();
			System.out.println(tel.getNumero());
		}
		DAOtel.close();
		System.out.println("\nTempo da consulta 1: "+(System.currentTimeMillis()-tempConsulta1));
		
		
		
		
		//Consulta 2: consulta envolvendo herança-----------------------------------------
		//Esta consulta trará tanto Usuarios do tipo Cliente quanto Administrador
		DAOusuarioIF DAOu = DAOFactory.getInstance("db4o").createUsuarioDAO();
		DAOu.begin();

		System.out.println("\n\nRealizando consulta 2...");
		long tempConsulta2 = System.currentTimeMillis();
		
		List<Usuario> usuarios = DAOu.listarUsuarios();
		
		System.out.println("\nClientes e Administradores resgatado(s): ");
		it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario u = (Usuario)it.next();
			System.out.print(u.getNome()+" - ");
		}
		DAOu.close();
		System.out.println("\nTempo da consulta 2: "+(System.currentTimeMillis()-tempConsulta2));
		
		
		
		
		//Consulta3: usar funcao de agregacao---------------------------------------------
		DAOtel = DAOFactory.getInstance("db4o").createTelefoneDAO();
		DAOtel.begin();

		System.out.println("\n\nRealizando consulta 3...");
		long tempConsulta3 = System.currentTimeMillis();		
		List<Telefone> tels = (List<Telefone>) DAOtel.groupByUsuario();
		
		System.out.println("Número total de telefones cadastrados: "+ DAOtel.totalTelefones());
		DAOtel.close();	
		System.out.println("\nTempo da consulta 3: "+(System.currentTimeMillis()-tempConsulta3));
		
		
		
		
		//Consulta4: subconsulta---------------------------------------------------------
		DAOcidadeIF DAOcity = DAOFactory.getInstance("db4o").createCidadeDAO();
		DAOcity.begin();

		System.out.println("\n\nRealizando consulta 4...");
		System.out.println("\n\nPegando as cidades que tem o mesmo estado 1...");
		long tempConsulta4 = System.currentTimeMillis();		
		List<Cidade> citys = (List<Cidade>) DAOcity.cidadesQueSaoDaUF1();
		
		it = citys.iterator();
		while (it.hasNext()) {
			Cidade c = (Cidade)it.next();
			System.out.println(c.getNome());
		}
		
		DAOcity.close();		
		System.out.println("\nTempo da consulta 4: "+(System.currentTimeMillis()-tempConsulta4));		
		

		
		
		//Consulta5: usar group by-------------------------------------------------------
		DAOtel = DAOFactory.getInstance("db4o").createTelefoneDAO();
		DAOtel.begin();
		System.out.println("\n\nRealizando consulta 5...");
		long tempConsulta5 = System.currentTimeMillis();
		HashMap<Usuario, List<Telefone>> tels2 = (HashMap<Usuario, List<Telefone>>) DAOtel.groupByUsuario2();
		
		DAOtel.close();		
		
		System.out.println("\nTelefones agrupados por usuário: ");
		
		for(Map.Entry<Usuario, List<Telefone>> t : tels2.entrySet()) {
			Usuario u = t.getKey();
			String nome = u.getNome();
			List<Telefone> tels_u = (List<Telefone>) t.getValue();			
			System.out.println(nome+": "+tels_u+"\n\n");
		}
		System.out.println("\nTempo da consulta 5: "+(System.currentTimeMillis()-tempConsulta5));	

		//---------------------------------------------------------------------------------		
		
		System.out.println("Tempo total de execucao: "+(System.currentTimeMillis()-temp));		
	}

}
