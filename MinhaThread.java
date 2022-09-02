
public class MinhaThread extends Thread {
	
	String nomeDoArquivo;
	String src;
	String dest;
	
	public MinhaThread(String nomeDoArquivo, String src, String dest) {
		this.nomeDoArquivo = nomeDoArquivo;
		this.src = src;
		this.dest = dest;
		start();
		
	}

	public void run() {
		CopiaArquivo copiar = new CopiaArquivo(nomeDoArquivo, src, dest);
	}
}
