package Model;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class LecturaPdf {
    public static void abrirPDF(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            Desktop.getDesktop().open(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}