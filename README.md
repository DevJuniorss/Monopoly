Para jogar basta executar a main e escolher a quantidade de jogadores
Siga as instruções e preste atenção ao tabuleiro

Diagrama de Sequencia Inserir Jogador

``` mermaid
sequenceDiagram
    participant Ator
    participant DesenhaComponentesGraficos
    participant ControladorJogo
    participant InsereJogador
    participant RepositorioJogador
    ControladorJogo->>+ControladorJogo: insereJogador()
    ControladorJogo->>+InsereJogador: inserirQtdJogadores()
    InsereJogador->>+DesenhaComponentesGraficos: showInputDialog()
    DesenhaComponentesGraficos->>+Ator: showOptions()
    Ator->>+DesenhaComponentesGraficos: showOptions
    DesenhaComponentesGraficos->>+InsereJogador: DesenhaComponentesGráficos
    InsereJogador-->>+ControladorJogo: return
        loop i < qtdJogadores
        ControladorJogo->>RepositorioJogador: adicionarJogador
        RepositorioJogador->>+Jogador: new()<<Creat>>    
        RepositorioJogador->>+RepositorioJogador:add(jogador)
        end
```

Diagrama de Sequencia Comprar Terreno

``` mermaid
sequenceDiagram
    participant Ator
    participant DesenhaComponentesGraficos
    participant ControladorJogo
    participant TerrenoComercializavel
    participant Jogador
    participant ContaBancaria
    ControladorJogo-->>+ControladorJogo: getProxCada(valor Dado)
    ControladorJogo-->>+TerrenoComercializavel: casa.instanceOfImovel | ativarEfeito(jogadorDaVez)
    TerrenoComercializavel-->>+DesenhaComponentesGraficos: casa.getProprietario() == null | showOptionPane
    DesenhaComponentesGraficos-->>+Ator: ShowOptionPane()
    Ator-->>-DesenhaComponentesGraficos: return
    DesenhaComponentesGraficos-->>+Jogador: Yes.Option | compar(casa)
    Jogador-->>+ContaBancaria: sacar(casa.valor)
    ContaBancaria-->>-Jogador: return
    Jogador-->>-DesenhaComponentesGraficos: return
    TerrenoComercializavel-->>+ContaBancaria: casa.getProprietario().equals(jogador).sacar(casa.getTaxa)
    ContaBancaria-->>-TerrenoComercializavel: return
    TerrenoComercializavel-->>+DesenhaComponentesGraficos: showAlertDialog()
    DesenhaComponentesGraficos-->>-TerrenoComercializavel: return
```

Diagrama de Classe com Organização de Pacotes

``` mermaid
classDiagram
  namespace Cenarios{
    class Cenario1{
    - faixaJogadorDaVez : Animation
    - dado2 : Dado
    - dado1 : Dado
    - teclado : Keyboard
    - jogadores : List<Jogador>
    - scene : Scene
    - window : Window
    + desenhaDados(id : int) : void
    + desenhaDados() : void
    + run() : void
    }
  }
namespace Baralho{
class VaParaCadeia{
+ ativarEfeito(jogador : Jogador) : void
+ VaParaCadeia(id : int, nome : String, efeito : float)
}

class IteratorSorteReves{
- IteratorSorteReves()
- cursorAtual : int
+ pegaCarta() : Carta
+ existeProximo() : boolean
+ getInstance() : IteratorSorteReves
}

class SaidaLivre{
+ ativarEfeito(jogador : Jogador) : void
+ SaidaLivre(id : int, nome : String, efeito : float)}

class AvanceInicioRecebe200{
+ ativarEfeito(jogador : Jogador) : void
+ AvanceInicioRecebe200(id : int, nome : String, valor : double)}

class InicializarBaralhoSorteReves{
+ inicialize() : void}

class Carta{
- valor : double
- nome : String
- id : int
+ ativarEfeito(jogador : Jogador) : void
+ Carta(id : int, nome : String, valor : double)}
}
  namespace Dados{
    class Dado{- valor : int
    + setValor(valor : int) : void
    + getValor() : int
    + mudarFace() : void
    + lancar() : void
    + Dado(x : int, y : int)
    }
    class ControladorDado{+ getValorDado() : int
    + randomDado() : int
    + verificaJogadasDuplas() : boolean
    }
    class RepositorioCasas{
    - RepositorioCasas()
    + getInstance() : RepositorioCasas
    + getCasaByPosicao(posicao : int) : Casa
    + getTodosTerrenos() : List<Casa>
    + getListCorPorCor(cor : String) : List<Casa>
    + getImoveisAzuisEscuro() : List<Casa>
    + getImoveisVerdes() : List<Casa>
    + getImoveisAmarelo() : List<Casa>
    + getImoveisRosas() : List<Casa>
    + getImoveisLaranjas() : List<Casa>
    + getImoveisLilas() : List<Casa>
    + getImoveisAzuis() : List<Casa>
    + getImoveisRoxos() : List<Casa>
    + getTerrenoEspecial() : List<Casa>
    + getTerrenoComercializavel() : List<Casa>}
    }
  namespace Baralho{
class VaParaCadeia{
+ ativarEfeito(jogador : Jogador) : void
+ VaParaCadeia(id : int, nome : String, efeito : float)
}

class IteratorSorteReves{
- IteratorSorteReves()
- cursorAtual : int
+ pegaCarta() : Carta
+ existeProximo() : boolean
+ getInstance() : IteratorSorteReves
}

class SaidaLivre{
+ ativarEfeito(jogador : Jogador) : void
+ SaidaLivre(id : int, nome : String, efeito : float)}

class AvanceInicioRecebe200{
+ ativarEfeito(jogador : Jogador) : void
+ AvanceInicioRecebe200(id : int, nome : String, valor : double)}

class InicializarBaralhoSorteReves{
+ inicialize() : void}

class Carta{
- valor : double
- nome : String
- id : int
+ ativarEfeito(jogador : Jogador) : void
+ Carta(id : int, nome : String, valor : double)}
}

namespace casa{

class Casa{
- y : int
- x : int
- id : int
- posicao : int
- nome : String
+ ativarEfeito(jogador : Jogador) : void
+ getY() : int
+ getX() : int
+ setPosicao(posicao : int) : void
+ getPosicao() : int
+ getNome() : String
+ getId() : int
+ Casa(nome : String, posicao : int, id : int, x : int, y : int)}

class Cadeia{
+ ativarEfeito(jogador : Jogador) : void
+ Cadeia(nome : String, posicao : int, id : int, x : int, y : int)
}

class ImpostoDeRenda{
+ ativarEfeito(jogador : Jogador) : void
+ ImpostoDeRenda(nome : String, posicao : int, id : int, x : int, y : int)}

class ParadaLivre{
+ ativarEfeito(jogador : Jogador) : void
+ ParadaLivre(nome : String, posicao : int, id : int, x : int, y : int)}

class VaiParaCadeia{
+ ativarEfeito(jogador : Jogador) : void
+ VaiParaCadeia(nome : String, posicao : int, id : int, x : int, y : int)}
class LucrosEDividendos{
+ ativarEfeito(jogador : Jogador) : void
+ LucrosEDividendos(nome : String, posicao : int, id : int, x : int, y : int)
}
class Partida{
+ ativarEfeito(jogador : Jogador) : void
+ Partida(nome : String, posicao : int, id : int, x : int, y : int)}
}

namespace terrenoComercializavel{
class Imovel{
- taxas[] : double
- valorCondominio : int
- countCondominios : int
- corImovel : String
+ ativarEfeito() : void}

class TerrenoComercializavel{
- proprietario : Jogador
- valor : double
+ ativarEfeitoCompanhia(jogador : Jogador, valorDados : int) : void
+ ativarEfeito(jogador : Jogador) : void}

class Companhia{
+ ativarEfeitoCompanhia() : void
+ getTaxaCompanhia() : void}
}

namespace Jogo{
class InsereCondominio{
+ validaRegraConstrucoes(jogador : Jogador, imovel : Imovel) : boolean
+ inserirCondominio(jogador : Jogador, imovel : Imovel) : void}

class ControladorJogo{
- iteraJogador : int
+ trocarJogadorDaVez() : void
+ getProxCasa(valor : int) : int
+ trocarFaixaJogador(id : int) : void
+ moverPecaJogador(valor : int) : void
+ lancarDados() : void
+ insereJogadores() : void
+ iniciarJogo() : void
+ ControladorJogo()}

class InsereJogador{
+ verificaQtdJogadores(qtdJogadores : int) : boolean
+ inserirQtdJogadores() : void
+ InsereJogador()}

class Tabuleiro{
+ inicialize() : void
+ Tabuleiro(casas : List<Casa>)}
}

namespace View{
class DesenhaComponenteGrafico{
+ mensagemVaiInicioGanha200() : void
+ mensagemConfirmacaoConstrucao() : int
+ mensagemSaiuComPasse() : void
+ mensagemConfirmacaoUsoPasseLivre() : int
+ mensagemVencedor(jogador : Jogador) : void
+ mensagemFalencia() : void
+ mensagemJogadorEhDono() : void
+ mensagemSoltoAposQuatroRodadas() : void
+ mensagemSaiuCadeiaComDupla() : void
+ mensagemCotinuaPreso() : void
+ mensagemPresoPorTresDuplas() : void
+ mensagemSaldoInsuficiente() : void
+ mostrarTerrenos(terrenos : List<TerrenoComercializavel>) : void
+ mostrarSaldoJogador(saldo : double) : void
+ mensagemPassouInicio() : void
+ mensagemImposto() : void
+ mensagemParadaLivre() : void
+ mensagemCadeiaVisitante() : void
+ mensagemLucrosDividendos() : void
+ mensagemPreso() : void
+ mensagemRevesVaParaCadeia() : void
+ mensagemSorteSaidaLivre() : void
+ mensagemSorteRecebe50DeTodos() : void
+ mensagemSorteReves(tipo : String, valor : double) : void
+ mensagemPagarTaxa(valor : double) : void
+ mensagemConfirmacaoCompra() : int
+ getCenario() : Cenario1
+ getTeclado() : Keyboard
+ mensagemInicial(jogadores : List<Jogador>) : void
+ desenhaPecasNoTabuleiroInicio() : void
+ telaInserirQtdJogador() : int
+ desenhaTabuleiro(jogadores : List<Jogador>) : void
+ lobby() : void
+ DesenhaComponenteGrafico()
}}

```