import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletaArquivo {

	public static void deletar(String nomeDoArquivo, String camilhoDoArquivo) {
		
		// create object of Path
        Path path = Paths.get(camilhoDoArquivo+nomeDoArquivo);
  
        // delete File
        try {
  
            Files.delete(path);
        }
        catch (IOException e) {
  
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}
}
