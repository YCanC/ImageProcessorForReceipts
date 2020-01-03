
package com.mycompany.mavenproject2;

import java.awt.Image;
import net.sourceforge.tess4j.*;
import org.opencv.highgui.*;
import org.opencv.core.*;
import org.opencv.imgproc.*;
import java.sql.*;
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO; 
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class fisSistemi extends javax.swing.JFrame {
    static Connection connection = null;
    static String databaseName = "yazlab1.1";
    static String url = "jdbc:mysql://localhost:3306/"+ databaseName+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    
    static String username = "root";
    static String password = "1234";
    
    String result = null;

    String selectedImage=null;
    
    String[] isletmeIsimleri;
   
    void comboBoxDuzenle(){
        String firstName = null;
       //Veritabanındaki işletme isimlerini comboBoxda gösterme kısmı
       try{
        jComboBox1.removeAllItems();
        connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement("SELECT `marketismi` FROM `yazlab1.1`.marketler");    
        ResultSet rs = statement.executeQuery();
        //rs.getString(MarketIsmi);
        
      while (rs.next())
      {
        //int id = rs.getInt("marketId");
          firstName = rs.getString("marketismi");
          jComboBox1.addItem(firstName);
        // print the results
        //System.out.format("%s", id);
         // System.out.println("firstName: "+firstName);
      }
      //     System.out.println("firstName: "+firstName);
         statement.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        //jComboBox1.removeAllItems();
        if(firstName!=null)
        {
         
        }
    }
    
    void comboBoxDuzenle2(){
        String firstName = null;
       //Veritabanındaki işletme isimlerini comboBoxda gösterme kısmı
       try{
        jComboBox2.removeAllItems();
        connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement("SELECT `Tarih` FROM `yazlab1.1`.fisler");    
        ResultSet rs = statement.executeQuery();
        //rs.getString(MarketIsmi);
        
      while (rs.next())
      {
        //int id = rs.getInt("marketId");
          firstName = rs.getString("Tarih");
          jComboBox2.addItem(firstName);
        // print the results
        //System.out.format("%s", id);
         // System.out.println("firstName: "+firstName);
      }
      //     System.out.println("firstName: "+firstName);
         statement.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        //jComboBox1.removeAllItems();
        if(firstName!=null)
        {
         
        }
    }
    
  
    public fisSistemi() {
        initComponents();
        comboBoxDuzenle();
        comboBoxDuzenle2();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ParseResults = new javax.swing.JTextArea();
        SelectImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameSearch = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        OcrResults = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        StartOcr = new javax.swing.JButton();
        DDaySearch = new javax.swing.JButton();
        ShowInfortmationTable = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ParseResults.setColumns(20);
        ParseResults.setRows(5);
        jScrollPane1.setViewportView(ParseResults);

        SelectImage.setText("Select Image");
        SelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectImageActionPerformed(evt);
            }
        });

        jLabel1.setText("Parse Results");

        nameSearch.setText("Business Names");

        jLabel2.setText("Search Date Day");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FisId", "MarketId", "Tarih", "FişNo", "Urunler", "Toplam", "MarketId", "Market İsmi"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        OcrResults.setColumns(20);
        OcrResults.setRows(5);
        jScrollPane5.setViewportView(OcrResults);

        jLabel5.setText("OCR Results");

        StartOcr.setText("Start OCR Process");
        StartOcr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartOcrActionPerformed(evt);
            }
        });

        DDaySearch.setText("Search");
        DDaySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DDaySearchActionPerformed(evt);
            }
        });

        ShowInfortmationTable.setText("Show All Information");
        ShowInfortmationTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowInfortmationTableActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("CompressImage");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Sort Business Names Alphabetically ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Parse Results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(nameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, 196, Short.MAX_VALUE)
                                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(72, 72, 72)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DDaySearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(StartOcr, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ShowInfortmationTable, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jButton1)))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectImage)
                    .addComponent(StartOcr)
                    .addComponent(jButton3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DDaySearch))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ShowInfortmationTable)
                            .addComponent(jButton1))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectImageActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png","jpg","jpeg");
        fileChooser.setFileFilter(filter);
        int selected = fileChooser.showOpenDialog(null);
        
        if(selected == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            String getselectedImage = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null,getselectedImage);
            
            
            ImageIcon imIco = new ImageIcon(getselectedImage);
            System.out.println("getselectedImage = "+getselectedImage);
            Image imFit = imIco.getImage();
            Image imgFit = imFit.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            
            selectedImage=getselectedImage;
            
            label.setIcon(new ImageIcon(imgFit));
            
        }
        
    }//GEN-LAST:event_SelectImageActionPerformed

    private void StartOcrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartOcrActionPerformed
       
          ParseProcess parsing = new ParseProcess();
       int i=0;
        //********************************OpenCV kısmı****************************************************************
       try{
            nu.pattern.OpenCV.loadShared();
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        /*
           //Resize kısmı 
            Mat image = Highgui.imread(selectedImage, Highgui.CV_LOAD_IMAGE_COLOR); 
             Mat resizeimage = new Mat();
             Size sz = new Size(4096,8192);
             Imgproc.resize( image, resizeimage, sz );
             Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\test\\fisresized.jpeg",resizeimage);
             */
            //Opencv iyileştirme kısmı
            Mat destination = new Mat();
            Mat source= Highgui.imread(selectedImage, Highgui.CV_LOAD_IMAGE_COLOR); 
            for(i=0; i<=2; i++){
               destination = new Mat(source.rows(), source.cols(), source.type()); 
               
               
               Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10); 
               Core.addWeighted(source, 1.5, destination, -0.5, 0, destination); 
               
               
               Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\test\\fisislem"+Integer.toString(i)+".jpeg", destination);
               source = destination;
            }
            
            //Mat result2= new Mat();
            Mat resultMat= new Mat();
            Imgproc.threshold(destination, resultMat,65,255, Imgproc.THRESH_BINARY);
            Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\test\\fisislemSon"+Integer.toString(i)+".jpeg", resultMat); 
           
            
          // Creating an empty matrix to store the result
           Mat dst = new Mat();

                 // Creating kernel matrix
           Mat kernel = Mat.ones(2,2, CvType.CV_32F);
           Imgproc.morphologyEx(resultMat, dst, Imgproc.MORPH_RECT, kernel);
           Highgui.imwrite("C:\\Users\\yasarcanc\\Desktop\\test\\fisislemSon8.jpeg",dst); 
           
        }
        catch(Exception e){
            System.out.println("Hata oluştu:"+e.getMessage());
        }
        
       
   
       File imageFile = new File("C:\\Users\\yasarcanc\\Desktop\\test\\fisislemSon8.jpeg");
        Tesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setLanguage("tur");
        instance.setDatapath("C:\\Users\\yasarcanc\\Desktop\\Tess4J\\tessdata"); // path to tessdata directory

        try {
            result = instance.doOCR(imageFile);
            
            //parsing.parseProcessing(result);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
       
        OcrResults.setText(result);
        
        newScreen ns = new newScreen();
        ns.newWindow();
       
        //** Parse işlemlerini yazdırma kısmı **
        
        String MarketIsmi = parsing.IsimBul(result);
        String Tarih= parsing.TarihBul(result);
        String FisNo = parsing.FisNoBul(result);
        String Urun= parsing.UrunBul(result);
        String Toplam= parsing.ToplamBul(result);
        
        ParseResults.setText(MarketIsmi+"\n"+Tarih+"\n"+FisNo+"\n"+ Urun+"\n"+Toplam);
        
        //VERİTABANI KISMI***************************************************
        
       String firstName =null;
       //Veritabanında önceden aynı marketin olup olmadığını kontrol etme kısmı
       try{
         connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement("SELECT `marketismi` FROM `yazlab1.1`.marketler WHERE marketismi=(?);");    
        statement.setString(1, MarketIsmi);    
        ResultSet rs = statement.executeQuery();
        //rs.getString(MarketIsmi);
        
      while (rs.next())
      {
        //int id = rs.getInt("marketId");
          firstName = rs.getString("marketismi");
        // print the results
        //System.out.format("%s", id);
         // System.out.println("firstName: "+firstName);
      }
           System.out.println("firstName: "+firstName);
         statement.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        

        //Veritabanına yeni market ekleme kısmı 
        if(firstName==null)
        {
         try {
            //*************************veritabanı kısmı*******************************
            connection = DriverManager.getConnection(url,username,password);
            String isletme_ekle_sql = "INSERT INTO `yazlab1.1`.`marketler` (`marketismi`) VALUES (?);";
            PreparedStatement ps = connection.prepareStatement(isletme_ekle_sql);
            ps.setString(1, MarketIsmi);
            int status = ps.executeUpdate();
            
            
            if(status !=0){
            System.out.println("Database was Connection");
            System.out.println("Record was inserted");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        comboBoxDuzenle();
        
         //Market id sine ulaşma kısmı..
        int id=-1;
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT `marketId` FROM `yazlab1.1`.marketler WHERE marketismi=(?);");    
        statement.setString(1, MarketIsmi);    
        ResultSet rs = statement.executeQuery();
        //rs.getString(MarketIsmi);
        
           while (rs.next())
      {
         id= rs.getInt("marketId");
        //String firstName = rs.getString("marketismi");
        
        // print the results
        //System.out.format("%s", id);
          System.out.println(id);
      }
         statement.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        if(id!=-1)
        {
            //INSERT INTO `yazlab1.1`.`fisler` (`marketId`, `Tarih`, `FisNo`, `Urunler`, `Fiyat`) VALUES ('1', 'Tarihh', 'FisNNUMARAS', 'urunn', 'fiyatt');
             try {
            //*************************veritabanı kısmı*******************************
            connection = DriverManager.getConnection(url,username,password);
            String isletme_ekle_sql = "INSERT INTO `yazlab1.1`.`fisler` (`marketId`, `Tarih`, `FisNo`, `Urunler`, `Fiyat`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(isletme_ekle_sql);
            ps.setInt(1, id);
            ps.setString(2,Tarih);
            ps.setString(3,FisNo);
            ps.setString(4,Urun);
            ps.setString(5,Toplam);
            
            
            int status = ps.executeUpdate();
            
            if(status !=0){
            System.out.println("Database was Connection");
            System.out.println("Record was inserted");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        comboBoxDuzenle();
        comboBoxDuzenle2();
        
    }//GEN-LAST:event_StartOcrActionPerformed

    
    private void ShowInfortmationTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowInfortmationTableActionPerformed
                comboBoxDuzenle();
                comboBoxDuzenle2();
        try{
        connection = DriverManager.getConnection(url,username,password);
        PreparedStatement ps = connection.prepareStatement("select * from fisler inner join marketler on fisler.marketId= marketler.marketId;");
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
        tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getInt("fisId"),rs.getString("marketId"),rs.getString("Tarih"),rs.getString("FisNo"),rs.getString("Urunler"),rs.getString("Fiyat"),rs.getString("marketId"),rs.getString("marketismi")};
                tm.addRow(o);
            }
        }
        catch(SQLException e)
        {
            
        }
        
    }//GEN-LAST:event_ShowInfortmationTableActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          File input = new File(selectedImage);
    BufferedImage image = null;
        try {
            image = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }

    File compressedImageFile = new File(selectedImage);
    OutputStream os=null;
        try {
            os = new FileOutputStream(compressedImageFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }

    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
    ImageWriter writer = (ImageWriter) writers.next();

    ImageOutputStream ios = null;
        try {
            ios = ImageIO.createImageOutputStream(os);
        } catch (IOException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }
    writer.setOutput(ios);

    ImageWriteParam param = writer.getDefaultWriteParam();

    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    param.setCompressionQuality(0.5f);  // Change the quality value you prefer
        try {
            writer.write(null, new IIOImage(image, null, null), param);
        } catch (IOException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ios.close();
        } catch (IOException ex) {
            Logger.getLogger(fisSistemi.class.getName()).log(Level.SEVERE, null, ex);
        }
    writer.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String comboBoxValue = (String)jComboBox1.getSelectedItem();
        System.out.println("comboBoxValue: "+comboBoxValue);
        try{
             connection = DriverManager.getConnection(url,username,password);
            String isletme_ara = "select * from fisler inner join marketler on fisler.marketId= marketler.marketId where marketler.marketismi =(?)";
            PreparedStatement ps = connection.prepareStatement(isletme_ara);
            ps.setString(1, comboBoxValue);
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getInt("fisId"),rs.getString("marketId"),rs.getString("Tarih"),rs.getString("FisNo"),rs.getString("Urunler"),rs.getString("Fiyat"),rs.getString("marketId"),rs.getString("marketismi")};
                tm.addRow(o);
            }
        }
        catch(SQLException e)
        {
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void DDaySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DDaySearchActionPerformed
        // TODO add your handling code here:
               String comboBoxValue = (String)jComboBox2.getSelectedItem();
        System.out.println("comboBoxValue: "+comboBoxValue);
        try{
             connection = DriverManager.getConnection(url,username,password);
            String isletme_ara = "select * from fisler inner join marketler on fisler.marketId= marketler.marketId where fisler.Tarih =(?)";
            PreparedStatement ps = connection.prepareStatement(isletme_ara);
            ps.setString(1, comboBoxValue);
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getInt("fisId"),rs.getString("marketId"),rs.getString("Tarih"),rs.getString("FisNo"),rs.getString("Urunler"),rs.getString("Fiyat"),rs.getString("marketId"),rs.getString("marketismi")};
                tm.addRow(o);
            }
        }
        catch(SQLException e)
        {
            
        }
    }//GEN-LAST:event_DDaySearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try{
        connection = DriverManager.getConnection(url,username,password);
        PreparedStatement ps = connection.prepareStatement("select * from fisler inner join marketler on fisler.marketId= marketler.marketId ORDER BY marketismi ASC;");
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
        tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getInt("fisId"),rs.getString("marketId"),rs.getString("Tarih"),rs.getString("FisNo"),rs.getString("Urunler"),rs.getString("Fiyat"),rs.getString("marketId"),rs.getString("marketismi")};
                tm.addRow(o);
            }
        }
        catch(SQLException e)
        {
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, SQLException {
 
        //***********************************arayüz kısmı*******************************************************************
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fisSistemi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fisSistemi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fisSistemi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fisSistemi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fisSistemi().setVisible(true);
            }
        });
        //***********************************arayüz kısmı*******************************************************************
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DDaySearch;
    private javax.swing.JTextArea OcrResults;
    private javax.swing.JTextArea ParseResults;
    private javax.swing.JButton SelectImage;
    private javax.swing.JButton ShowInfortmationTable;
    private javax.swing.JButton StartOcr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel nameSearch;
    // End of variables declaration//GEN-END:variables
}
