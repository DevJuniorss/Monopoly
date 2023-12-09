package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Casa.Casa;
import Casa.TerrenoComercializavel.Imovel;
import Casa.TerrenoComercializavel.TerrenoComercializavel;

public class RepositorioCasas {
	private List<Casa> casasTabuleiro = new ArrayList<>();
	private static RepositorioCasas instance;
	private RepositorioCasas () {
	}
	public static RepositorioCasas getInstance() {
		if (instance == null) {
			instance = new RepositorioCasas();
		}
		return instance;
	}
	public List<Casa> getTerrenoComercializavel(){
		List<Casa> terrenosComercializaveis = new ArrayList<>();
		for (Casa terreno : casasTabuleiro) {
			if (terreno instanceof TerrenoComercializavel) {
				terrenosComercializaveis.add(terreno);
			}
		}
		return terrenosComercializaveis;
	}
	public List<Casa> getTerrenoEspecial(){
		List<Casa> terrenosEspeciais = new ArrayList<>();
		for (Casa terreno : casasTabuleiro) {
			if (!(terreno instanceof TerrenoComercializavel)) {
				terrenosEspeciais.add(terreno);
			}
		}
		return terrenosEspeciais;
	}
	public List<Casa> getImoveisRoxos(){
		List<Casa> roxos = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Roxo")) {
					roxos.add(imovel);
				}
			}
		}
		return roxos;
	}
	public List<Casa> getImoveisAzuis(){
		List<Casa> azuis = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Azul")) {
					azuis.add(imovel);
				}
			}
		}
		return azuis;
	}
	public List<Casa> getImoveisLilas(){
		List<Casa> lilas = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Lilas")) {
					lilas.add(imovel);
				}
			}
		}
		return lilas;
	}
	public List<Casa> getImoveisLaranjas(){
		List<Casa> laranjas = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Laranja")) {
					laranjas.add(imovel);
				}
			}
		}
		return laranjas;
	}
	public List<Casa> getImoveisRosas(){
		List<Casa> rosas = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Rosa")) {
					rosas.add(imovel);
				}
			}
		}
		return rosas;
	}
	public List<Casa> getImoveisAmarelo(){
		List<Casa> amarelos = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Amarelo")) {
					amarelos.add(imovel);
				}
			}
		}
		return amarelos;
	}
	public List<Casa> getImoveisVerdes(){
		List<Casa> verdes = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Verde")) {
					verdes.add(imovel);
				}
			}
		}
		return verdes;
	}
	public List<Casa> getImoveisAzuisEscuro(){
		List<Casa> azulEscuro = new ArrayList<>();
		for (Casa imovel : casasTabuleiro) {
			if (imovel instanceof Imovel) {
				if (((Imovel) imovel).getCorImovel().equals("Azul Escuro")) {
					azulEscuro.add(imovel);
				}
			}
		}
		return azulEscuro;
	}
	public List<Casa> getListCorPorCor(String cor){
		if(cor.equals("Lilas")) {
			return getImoveisLilas();
		} else if(cor.equals("Azul")) {
			return getImoveisAzuis();
		} else if(cor.equals("Roxo")) {
			return getImoveisRoxos();
		} else if(cor.equals("Laranja")) {
			return getImoveisLaranjas();
		} else if(cor.equals("Rosa")) {
			return getImoveisRosas();
		} else if (cor.equals("Amarelo")) {
			return getImoveisAmarelo();
		} else if(cor.equals("Verde")) {
			return getImoveisVerdes();
		} else {
			return getImoveisAzuisEscuro();
		}
	}
	public List<Casa> getTodosTerrenos(){
		return casasTabuleiro;
	}
	public Casa getCasaByPosicao(int posicao) {
		for (Casa c: casasTabuleiro) {
			if(c.getPosicao() == posicao) return c;
		}
		return null;
	}	
}