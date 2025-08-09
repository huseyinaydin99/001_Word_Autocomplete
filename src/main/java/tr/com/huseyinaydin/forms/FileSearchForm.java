package tr.com.huseyinaydin.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tr.com.huseyinaydin.services.DictionaryLoader;
import tr.com.huseyinaydin.services.impl.DictionaryServiceImpl;
import tr.com.huseyinaydin.services.impl.DictionaryFileReader;
import tr.com.huseyinaydin.services.impl.FileDictionaryLoaderImpl;
import tr.com.huseyinaydin.services.FileReaderService;

public class FileSearchForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(FileSearchForm.class.getName());
    private final FileReaderService fileReaderService;
    
    private DictionaryLoader loader;
    private DictionaryServiceImpl service;
    
    public FileSearchForm(FileReaderService fileReaderService) throws IOException {
        initComponents();
        this.fileReaderService = fileReaderService;
        loader = new FileDictionaryLoaderImpl("sozluk.txt");
        service = new DictionaryServiceImpl(loader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton1 = new javax.swing.JButton();
        searchTermText1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 120));

        searchButton1.setText("Ara");
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });

        searchTermText1.setToolTipText("Arama yapmak için kelime giriniz...");

        searchResultList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sonuç yok." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(searchResultList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchTermText1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton1))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton1)
                    .addComponent(searchTermText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        List<String> resultList = service.searchByPrefix(searchTermText1.getText().toLowerCase());
        if(resultList.size() <= 0 || searchTermText1.getText().isEmpty() || searchTermText1.getText().isBlank())
            resultList = new ArrayList<>(){
                {add("Sonuç yok.");}  
            };
        StringListModel listModel = new StringListModel(resultList);
        //System.out.println(service.searchByPrefix("BROWSA")); // browsa ile başlayan kelimeler
        searchResultList1.setModel(listModel);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton1;
    private javax.swing.JList<String> searchResultList1;
    private javax.swing.JTextField searchTermText1;
    // End of variables declaration//GEN-END:variables

}