package br.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoadPropriedade {

    private static Properties config = new Properties();
    private static String arquivo = "config.ini";//local do arquivo
    private static String enderecoDoJar; //new File(".").getCanonicalPath();//System.getProperty("user.dir");

    public static String loadProperty(String property) {

        try {
            enderecoDoJar =   Util.retornaCaminhoApp()+"/config.ini";
            File file = new File(enderecoDoJar);
            FileInputStream f = new FileInputStream(file);
            config.load(f);

            return config.getProperty(property);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Endereço: " + enderecoDoJar);
            return null;
        }

    }

}
