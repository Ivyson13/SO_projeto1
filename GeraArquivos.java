import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GeraArquivos {

	int qtdArquivos;
	int qtdpastas;
	String pastaRaiz = "Area_de_testes";
	String encoding = "UTF-8";

	String[][] listaDeArquivos = new String[10][];
	String[] listaDePastas = new String[10];

	GeraArquivos(int qtdArquivos, int qtdpastas) {
		
		this.qtdArquivos = qtdArquivos;
		this.qtdpastas = qtdpastas;

		// Criar n pastas.
		for (int i = 0; i < qtdpastas; i++) {

			String pasta = "Geração-" + RandomizadorAlphaNumerico.getRandomString(3);
			
			listaDePastas[i] = pasta;

			// cria a pasta onde os arquivos serão criados
			File origen = new File(pastaRaiz + "/" + pasta);

			// cria a pasta para onde os arquivos serão copiados
			File destino = new File(pastaRaiz + "/" + pasta + "/Destino");

			if (!origen.exists()) {
				origen.mkdirs();
				destino.mkdirs();
			} else {
				//TODO tratamento aqui!
			}

			// Guardar aquivos gerados nessa pasta
			String[] arquivosDaPasta= new String[qtdArquivos];
			
			// cirar N aquivos
			for (int j = 0; j < qtdArquivos; j++) {

				// criar nome aleatorio do aquivo
				String nomeArquivo = "Arquivo_" + RandomizadorAlphaNumerico.getRandomString(5) + ".txt";

				try{
					PrintWriter writer = new PrintWriter(origen+"/"+nomeArquivo, encoding);
					
					int qtdLinhas = 100000; 
					/**
					 * Com 100000 = 10Mb e 10000 = 1Mb 
					 * para 100 caracteres por linha
					 * e 10 pastas com 10 arquivos.
					 */
					
					for (int linha = 0; linha < qtdLinhas; linha++) {
						writer.println(RandomizadorAlphaNumerico.getRandomString(100));
					}
					
					writer.close();
				}
				catch (IOException e){
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				// Guarda os nomes dos aquivos dessa pasta
				arquivosDaPasta[j] = nomeArquivo;
			}
			
			// Guarda os nomes dos aquivos das pastas
			listaDeArquivos[i] = arquivosDaPasta;
		
			// Guarda os nomes das pastas
		}

	}
	
	public String getNomeDoArquivo(int posicaoPasta, int posicaoArquivo) {
		return listaDeArquivos[posicaoPasta][posicaoArquivo];
	}
	
	public String getNomeDaPasta(int posicao) {
		return listaDePastas[posicao];
	}
	
	public String getOrigen(int posicaoPasta) {
		return pastaRaiz + "/" + listaDePastas[posicaoPasta] + "/";
	}
	
	public String getDestino(int posicaoPasta) {
		return pastaRaiz + "/" + listaDePastas[posicaoPasta] + "/Destino/";
	}

}
