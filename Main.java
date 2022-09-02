import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int qtdpastas = 10; // Ou quantidade de veses
		int qtdAquivos = 10;

		long semThread = 0;
		long comThread = 0;

		System.out.println("Criando arquivos!\n -> Aguarde...");

		// Cria as pastas com arquivos
		GeraArquivos geracao = new GeraArquivos(qtdAquivos, qtdpastas);

		System.out.println("Arquivos Criados!\n\nCopia sem Threads:");


		// Percorre cada pasta para copiar os arquivos
		for (int posicaoPasta = 0; posicaoPasta < qtdpastas; posicaoPasta++) {

			System.out.print(" -> Copiando arquivos da pasta " + geracao.getOrigen(posicaoPasta));

			// Guarda o tempo inicial
			long tempoInicial = System.currentTimeMillis();

			for (int posicaoArquivo = 0; posicaoArquivo < qtdAquivos; posicaoArquivo++) {

				// Copiando os arquivos
				CopiaArquivo copiar = new CopiaArquivo(geracao.getNomeDoArquivo(posicaoPasta,posicaoArquivo), geracao.getOrigen(posicaoPasta), geracao.getDestino(posicaoPasta));			
			}	

			// Guarda o tempo final
			long tempoFinal = System.currentTimeMillis();

			System.out.println(" | Tempo"+(posicaoPasta+1)+": " + (tempoFinal - tempoInicial) + "ms");

			semThread += tempoFinal - tempoInicial;
		}


		// O tempo total é igual a diferença do tempo final e inicial
		System.out.println("\nTempo meido decorrido para copia sem Threads: " + (semThread/qtdpastas) + "ms");


		System.out.println("\n -> Apagando arquivos copiados...\n\nCopia sem Threads:");
		
		//
		for (int posicaoPasta = 0; posicaoPasta < qtdpastas; posicaoPasta++) {
			
			for (int posicaoArquivo = 0; posicaoArquivo < qtdAquivos; posicaoArquivo++) {

				DeletaArquivo.deletar(geracao.getNomeDoArquivo(posicaoPasta,posicaoArquivo), geracao.getDestino(posicaoPasta));
				
			}	
		}


		for (int posicaoPasta = 0; posicaoPasta < qtdpastas; posicaoPasta++) {

			System.out.print(" -> Copiando arquivos da pasta " + geracao.getOrigen(posicaoPasta));

			// Guarda o tempo inicial
			long tempoInicial = System.currentTimeMillis();

			for (int posicaoArquivo = 0; posicaoArquivo < qtdAquivos; posicaoArquivo++) {

				// Copiando os arquivos
				MinhaThread thread = new MinhaThread(
						geracao.getNomeDoArquivo(posicaoPasta,posicaoArquivo), 
						geracao.getOrigen(posicaoPasta), 
						geracao.getDestino(posicaoPasta)
						);
				
			}	

			// Guarda o tempo final
			long tempoFinal = System.currentTimeMillis();

			System.out.println(" | Tempo"+(posicaoPasta+1)+": " + (tempoFinal - tempoInicial) + "ms");

			comThread += tempoFinal - tempoInicial;
		}
		
		// O tempo total é igual a diferença do tempo final e inicial
			System.out.println("\nTempo meido decorrido para copia com Threads: " + (comThread/qtdpastas) + "ms");


		/** Exibir os nomes dos arquivos e suas pastas geradas
		try (Scanner ler = new Scanner(System.in)) {

			System.out.print("Ver lista de pastas e aquivos? (y/n) -");
			String opcao = ler.next();

			switch (opcao) {
			case "y":
				for (int i = 0; i < qtdpastas; i++) {

					System.out.print(geracao.getNomeDaPasta(i)+": ");

					for (int n = 0; n < qtdAquivos; n++) {

						System.out.print("["+(n+1)+"] "+geracao.getNomeDoArquivo(i,n)+" ");
					}
					System.out.println("");
				} break;
			}
		}
		 **/
	}
}