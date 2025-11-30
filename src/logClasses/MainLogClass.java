package logClasses;

import logInterface.InterfaceLogs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainLogClass implements InterfaceLogs {
    private static final String LOG_PATH =
            "C:\\Users\\PC\\Documents\\projetos-java\\leitor-pdf\\src\\configFiles\\books.log";

    private final Path logFilePath;
    protected String name;
    private LocalDateTime dateTime;
    protected Integer page;
    protected Float zoom;

    public MainLogClass(String name, Integer page, Float zoom){
        this.logFilePath = Paths.get(LOG_PATH);
        this.name = name;
        this.dateTime = LocalDateTime.now();
        this.page = page;
        this.zoom = zoom;
    }
    public MainLogClass(){
        this.logFilePath = Paths.get(LOG_PATH);
        this.name = "default";
        this.dateTime = LocalDateTime.now();
        this.page = 1;
        this.zoom = 150.5F;
    }

    private void checkPathExist() throws IOException{
        Path parentDir = logFilePath.getParent();
        if(parentDir != null && Files.notExists(parentDir)){
            System.out.println("Diretorio não encotrado, criado: "+ parentDir);
            Files.createDirectories(parentDir);
        }
        if(Files.notExists(logFilePath)){
            System.out.println("Files logs não encotradas. criando log ..."+ logFilePath);
            Files.createFile(logFilePath);
        }
        return;
    }

    @Override
    public void logNewBook(String nameBook, Integer page, Float zoom) throws IOException {
        MainLogClass logValuesNew = new MainLogClass(nameBook,page, zoom);
        checkPathExist();
        try(
                FileWriter fw = new FileWriter(logFilePath.toFile(), true);
                BufferedWriter bf= new BufferedWriter(fw)
        ){
            bf.write(logValuesNew.toString());
            bf.newLine();

        }catch (IOException e){
            throw new IOException("não foi possivel escrever o log.. "+e);
        }
    }

    //this log is for a book also read.
    @Override
    public void createLog(String name, Integer page, Float zoom) throws IOException {
        MainLogClass logvalues = new MainLogClass(name, page, zoom);
        checkPathExist();//this is very important
        try(//try values for finally auto.
            FileWriter fw = new FileWriter(logFilePath.toFile(), true);
            BufferedWriter bf = new BufferedWriter(fw)
        ){

            bf.write(logvalues.toString());
            bf.newLine();
        } catch (IOException e) {
            throw new IOException("não foi possivel escrever o log.. "+e);
        }
    return;
    }
    @Override
    public String toString() {
        // Formata a data/hora para ser legível no log.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // Retorna a linha completa do log.
        return String.format("[%s] Livro: %s, Página: %d, Zoom: %.1f%%",
                formattedDateTime,
                this.name,
                this.page,
                this.zoom
        );
    }
    //I do this to facillty test of codes
//    public static void main(String[] args) {
//        MainLogClass mainLogClass = new MainLogClass();
//        try {
//            mainLogClass.logNewBook("molestado", 60, 302.5F);
//            mainLogClass.createLog("algebra 1 para leigos", 245, 250.0F);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
