package tr.com.huseyinaydin.forms;

import java.io.IOException;
import tr.com.huseyinaydin.services.DictionaryLoader;
import tr.com.huseyinaydin.services.DictionaryService;
import tr.com.huseyinaydin.services.FileReaderService;
import tr.com.huseyinaydin.services.impl.DictionaryFileReader;
import tr.com.huseyinaydin.services.impl.FileDictionaryLoader;

public class FileSearchForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(FileSearchForm.class.getName());
    private final FileReaderService fileReaderService;
    
    private DictionaryLoader loader;
    private DictionaryService service;
    
    public FileSearchForm(FileReaderService fileReaderService) throws IOException {
        initComponents();
        this.fileReaderService = fileReaderService;
        loader = new FileDictionaryLoader("sozluk.txt");
        service = new DictionaryService(loader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 120));

        searchButton1.setText("Ara");
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(searchButton1)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(searchButton1)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        System.out.println(service.searchByPrefix("BROWSA")); // browsa ile başlayan kelimeler
    }//GEN-LAST:event_searchButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FileSearchForm(new DictionaryFileReader("sozluk.txt")).setVisible(true);
            } catch (IOException ex) {
                System.getLogger(FileSearchForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton searchButton1;
    // End of variables declaration//GEN-END:variables

}