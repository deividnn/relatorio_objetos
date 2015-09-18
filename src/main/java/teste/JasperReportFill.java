package teste;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author prog
 */
public class JasperReportFill {

    public static void main(String[] args) throws IOException, JRException {
        new JasperReportFill().gerar();
    }

    public void gerar() throws IOException, JRException {
        InputStream initialStream = FileUtils.openInputStream(
                new File("src/main/java/resources/teste.jasper"));

        File targetFile = new File("src/main/java/resources/teste2.jasper");

        FileUtils.copyInputStreamToFile(initialStream, targetFile);
        String sourceFileName
                = targetFile.getAbsolutePath();

        FabricaCliente FabricaCliente = new FabricaCliente();
        ArrayList<Cliente> dataList = FabricaCliente.clientes();

        JRBeanCollectionDataSource beanColDataSource
                = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();
        String printFileName = null;
        /**
         * Passing ReportTitle and Author as parameters
         */

        printFileName = JasperFillManager.fillReportToFile(
                sourceFileName,
                parameters,
                beanColDataSource);
        if (printFileName != null) {
            JasperViewer.viewReport(printFileName, false);
        }
    }

}
