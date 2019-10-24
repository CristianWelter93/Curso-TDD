package leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {


		if(lances.isEmpty() || podeDarLance(lance.getUsuario())){
			lances.add(lance);
		}
	}

	public void dobralance(Usuario usuario){
		int quantidadeLancesParaProcurar= qtdeDeLancesDoUsuario(usuario);
		int posicaoUltimoLance=0;

		if(podeDarLance(usuario)){
			propoe(new Lance(usuario,procurarUltimoLanceUsuario(usuario).getValor()*2));
		}
		return;
	}

	private Lance procurarUltimoLanceUsuario(Usuario usuario){
		Lance ultimoLance=null;
		for(Lance lance:lances){
			if(lance.getUsuario().equals(usuario)){
				ultimoLance=lance;
			}
		}
		return ultimoLance;
	}

	private boolean podeDarLance(Usuario usuario) {
		return  !ultimoLanceDado().getUsuario().equals(usuario) && qtdeDeLancesDoUsuario(usuario) < 5;
	}

	private int qtdeDeLancesDoUsuario(Usuario usuario) {
		int total=0;

		for(Lance l: lances){
			if(l.getUsuario().equals(usuario)){
				total++;
			}
		}
		return total;
	}

	private Lance ultimoLanceDado(){
		return lances.get(lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
}
