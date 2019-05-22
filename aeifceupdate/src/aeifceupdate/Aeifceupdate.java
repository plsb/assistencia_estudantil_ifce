package aeifceupdate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.LoadPropriedade;
import util.Util;

/**
 *
 * @author pelusb
 */
public class Aeifceupdate {

    public static void main(String[] args) {
         UpdateFrm upFrm = new UpdateFrm();
         upFrm.setVisible(true);
        try {
            new Thread().sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aeifceupdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            URLConnection connection = new URL(LoadPropriedade.loadProperty("path_server_verify_online")).openConnection();
            connection.connect();
           
            File fileDelete = new File(LoadPropriedade.loadProperty("name_software"));
            fileDelete.delete();
            Util.gravaArquivoDeURL(LoadPropriedade.loadProperty("path_server_update"), Util.retornaCaminhoApp());
            Process p = Runtime.getRuntime().exec("java -jar "+Util.retornaCaminhoApp()+"/"+
                                                    LoadPropriedade.loadProperty("name_software"));
            System.exit(0);
        } catch (IOException ioexcp) {
            JOptionPane.showMessageDialog(null, "Sem conexão com Internet", "IFCE", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

 
}
