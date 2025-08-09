package tr.com.huseyinaydin.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class BasicSearchForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(BasicSearchForm.class.getName());
    private static String[] nameArray = {"Hüseyin AYDIN", "Hüseyin AYDIN", "Özge PİRİNÇ", "Salih BAKIRCI", "Cumali ATEŞ", "Mehmet YAĞCI", "Ender YILDIRIM", "Saadet ATEŞHARMAN", "Selami ZIMBA", "Celal YILMAZ"};
    private static List<String> nameList;
    private static TreeSet<String> nameSet;
    private static int wordCount = 0;

    public BasicSearchForm() {
        initComponents();
        nameList = new ArrayList<>();
        nameSet = new TreeSet<>();
        //nameSet.addAll(Arrays.asList(nameArray));
        for (String name : nameArray) {
            if (nameSet.add(name)) {
                //System.out.println("Set / Küme'ye eklenebildi!");
            } else {
                System.err.println("Set / Küme'ye eklenemedi! Eklenemeyen: " + name);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelime Arama Uygulaması");
        setLocation(new java.awt.Point(500, 125));
        setSize(new java.awt.Dimension(300, 300));

        jButton1.setText("Array Üzerinden Ara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("-");

        jScrollPane1.setViewportView(jList1);

        jButton2.setText("TreeSet / Sıralı Küme Üzerinden Ara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        button1.setActionCommand("");
        button1.setLabel("Node'lara Göre Ara");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        wordCount = 0;
        jList1.removeAll();
        nameList.clear();
        for (String arrayOfName : nameArray) {
            if (arrayOfName.toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                nameList.add(arrayOfName);
                wordCount++;
            }
        }
        StringListModel listModel = new StringListModel(nameList);
        jList1.setModel(listModel);
        jLabel1.setText("Bulunan isim sayısı: " + String.valueOf(wordCount));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("Tree Arama Basıldı! Tree Size: " + nameSet.getFirst());
        wordCount = 0;
        jList1.removeAll();
        nameList.clear();

        nameSet.stream().forEach(e -> {
            System.out.println("TreeSet Eleman: " + e);
            System.out.println("döngü test");
            String arrayOfName = e;
            System.out.println("Elde edilen: ");
            System.out.println(arrayOfName);
            if (arrayOfName.toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                System.out.println("if test");
                nameList.add(arrayOfName);
                wordCount++;
            }
        });

        StringListModel listModel = new StringListModel(nameList);
        jList1.setModel(listModel);
        jLabel1.setText("Bulunan isim sayısı: " + String.valueOf(wordCount));
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BasicSearchForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
