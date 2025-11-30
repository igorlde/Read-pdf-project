import entity.ReadPdfCore;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      ReadPdfCore readPdfCore = new ReadPdfCore();
//        String text = readPdfCore.readPDF("C:\\Users\\PC\\Documents\\Sistemas-opreacionais\\Governos-apos-ditadura.pdf", 3);
//        System.out.println(text);
        try {
            readPdfCore.mixLogOfBooks("C:\\Users\\PC\\Documents\\Sistemas-opreacionais\\Governos-apos-ditadura.pdf",
                    2, 148.8F);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}