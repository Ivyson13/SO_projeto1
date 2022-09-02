import java.io.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;

public class CopiaArquivo {

	public CopiaArquivo(String nomeDoArquivo, String src, String dest) {
		
		// caminho do arquivo de origem
		String  sourcePath = src + nomeDoArquivo;
		
		// caminho do arquivo de destino
		String destinationPath= dest;
		
		// Criando um arquivo de origem
		File sourceFile = new File(sourcePath);
		
		// Criando um arquivo de destino. O nome permanece o mesmo desta forma, referindo-se a getName()
		File destinationFile = new File(destinationPath+sourceFile.getName());
		
		try 
		{
			Files.copy(sourceFile.toPath(), destinationFile.toPath(),REPLACE_EXISTING);  
			// métodos estáticos para copiar Copiar o caminho de origem para o caminho de destino
		} catch(Exception e)
		{
			System.out.println(e);  // printing em caso de erro.
		}
	}
}