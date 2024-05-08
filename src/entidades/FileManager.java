package entidades;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {


    public File criarPasta(String path) {
        File diretorio =  new File(path);
        if (!diretorio.exists())
            diretorio.mkdir();

        return diretorio;
    }

    public File criarArquivo(File diretorio, String fileName) throws IOException {
        File file =  new File(diretorio, fileName);
        if (!file.exists())
            file.createNewFile();

        return file;
    }

    public void gravarDados(File file, Ingresso ingresso) throws IOException {

            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Id: " +ingresso.getId());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print("Cadeira: " + ingresso.getCadeira());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print(ingresso.getCliente());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print(ingresso.getHorario());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print(ingresso.getFilme());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print("Valor: R$"+ingresso.getValor());
            printWriter.print(";");
            printWriter.print("\n");
            printWriter.print("\n");
            printWriter.print("\n");
            printWriter.print("\n");
            printWriter.flush();
            printWriter.close();

    }
}

