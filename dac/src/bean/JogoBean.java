package bean;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import dao.JogoDao;
import entidade.Jogo;



@javax.faces.bean.ManagedBean
public class JogoBean {
	
	private Jogo jogo = new Jogo();
	private List<Jogo> lista;
	
	public String salvar() {
		try {
			JogoDao.salvar(jogo);
			addInfoMessage("Sucesso", "Jogo salvo com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao salvar o jogo.");
		}
		
		return null;
	}
	
	
	public String excluir(Jogo jogo) {
		try {
			JogoDao.excluir(jogo);
			addInfoMessage("Sucesso", "Jogo excluido com sucesso.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao excluir o jogo.");
		}
		return null;
	}
	
	
	
	public void onRowEdit(RowEditEvent<Jogo> event) {
		try {
			JogoDao.editar(event.getObject());
			addInfoMessage("Sucesso", "Jogo editado!");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao editar o jogo.");
		}
		
    }

    public void onRowCancel(RowEditEvent<Jogo> event) {
			addInfoMessage("Sucesso", "Edição cancelada.");
    }
    
    
    
    public void maior(Jogo jogo) {
    		JogoDao.retornoMaior(jogo);
			addInfoMessage("Sucesso", "O maior número da linha do ID " + jogo.getId() + " é o " + jogo.getMaior());
			
    	
	}
	
	
   	
	
	
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public List<Jogo> getLista() {
		if(lista == null) {
			lista = JogoDao.listar();
		}
		return lista;
	}
	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
	

}
