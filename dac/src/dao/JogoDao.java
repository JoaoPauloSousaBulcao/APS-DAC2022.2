package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDao {
	
	public static void salvar(Jogo j) {
		EntityManager li = JPAUtil.criarEntityManager();
		li.getTransaction().begin();
		j.setMaior();
		li.persist(j);
		li.getTransaction().commit();
		li.close();
		
	}
	
	public static void editar(Jogo j) {
		EntityManager li = JPAUtil.criarEntityManager();
		li.getTransaction().begin();
		j.setMaior();
		li.merge(j);
		li.getTransaction().commit();
		li.close();
	}
	
	public static void excluir(Jogo j) {
		EntityManager li = JPAUtil.criarEntityManager();
		li.getTransaction().begin();
		j = li.find(Jogo.class, j.getId());
		li.remove(j);
		li.getTransaction().commit();
		li.close();
	}
	
	public static List<Jogo> listar(){
		EntityManager li = JPAUtil.criarEntityManager();
		Query g = li.createQuery("select j from Jogo j");
		List<Jogo> lista = g.getResultList();
		li.close();
		return lista;
	}
	
	
	public static Integer retornoMaior(Jogo j) {
		EntityManager li = JPAUtil.criarEntityManager();
		li.getTransaction().begin();
		j = li.find(Jogo.class, j.getId());
		li.getTransaction().commit();
		li.close();
		return j.getMaior();
		
		
	}



}
