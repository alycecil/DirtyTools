import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class rename {
    public static void main(String... args) throws IOException {
        File f = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\RimWorld\\Mods\\Pokemon\\Sounds");
        for (File file : f.listFiles()) {
            String name = file.getName();
            name = name.substring(0,4).trim()+".wav";

            file.renameTo(new File(f,name));
        }
    }
}
