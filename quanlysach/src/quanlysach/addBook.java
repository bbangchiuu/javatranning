/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BangNguyen
 */
public class addBook implements ActionListener {

    JFrame f, Danhsach;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem listItem;
    JLabel title, idText, nameText, conntentText, priceText, authorText, categoryText;
    JTextField idField, nameField, conntentField, priceField, authorField, categoryField;
    JButton addBook;

    JLabel erroID, erroName, erroConntent, erroPrice, erroCategory, erroAuthor;

    Pattern pattern;
    
    private boolean trueID = false, trueCategory = false, trueName = false, trueConn = false, trueAuthor = false, truePrice = false;
    
    ArrayList<Books> listBooks = new ArrayList();
    public addBook() {
        f = new JFrame("quan ly sach");

        menubar = new JMenuBar();
        menu = new JMenu("View");
        listItem = new JMenuItem("List");
        listItem.addActionListener(this);
        menu.add(listItem);
        menubar.add(menu);

        //tieu de
        title = new JLabel("Nhập thông tin sách");
        title.setBounds(300, 10, 200, 60);
        f.add(title);

        //id
        idText = new JLabel();
        idText.setBounds(10, 100, 100, 40);
        idText.setText("Id:");
        f.add(idText);

        idField = new JTextField();
        idField.setBounds(120, 100, 100, 40);
        f.add(idField);
        
        //errorId
        erroID = new JLabel();
        erroID.setBounds(120, 150, 120, 40);
        f.add(erroID);
        
        //name
        nameText = new JLabel();
        nameText.setBounds(10, 200, 100, 40);
        nameText.setText("name:");
        f.add(nameText);

        nameField = new JTextField();
        nameField.setBounds(120, 200, 100, 40);
        f.add(nameField);
        
        //errorName
        erroName = new JLabel();
        erroName.setBounds(120, 250, 120, 40);
        f.add(erroName);
        
        //auothor
        authorText = new JLabel();
        authorText.setBounds(250, 100, 100, 40);
        authorText.setText("auothor:");
        f.add(authorText);

        authorField = new JTextField();
        authorField.setBounds(350, 100, 100, 40);
        f.add(authorField);
        
        //errorAuthor
        erroAuthor = new JLabel();
        erroAuthor.setBounds(350, 150, 150, 40);
        f.add(erroAuthor);
        
        //category
        categoryText = new JLabel();
        categoryText.setBounds(250, 200, 100, 40);
        categoryText.setText("Category:");
        f.add(categoryText);

        categoryField = new JTextField();
        categoryField.setBounds(350, 200, 100, 40);
        f.add(categoryField);

        //errorAuthor
        erroCategory = new JLabel();
        erroCategory.setBounds(350, 250, 150, 40);
        f.add(erroCategory);
        
        //conntent
        conntentText = new JLabel();
        conntentText.setBounds(500, 100, 100, 40);
        conntentText.setText("conntent:");
        f.add(conntentText);

        conntentField = new JTextField();
        conntentField.setBounds(600, 100, 100, 40);
        f.add(conntentField);
        
        //errorConntent
        erroConntent = new JLabel();
        erroConntent.setBounds(600, 150, 150, 40);
        f.add(erroConntent);
        
        //price
        priceText = new JLabel();
        priceText.setBounds(500, 200, 100, 40);
        priceText.setText("price:");
        f.add(priceText);

        priceField = new JTextField();
        priceField.setBounds(600, 200, 100, 40);
        f.add(priceField);

        //errorPirce
        erroPrice = new JLabel();
        erroPrice.setBounds(600, 250, 120, 40);
        f.add(erroPrice);
        
        //button
        addBook = new JButton("Add");
        addBook.setBounds(10, 280, 100, 40);
        addBook.addActionListener(this);
        f.add(addBook);

        f.setJMenuBar(menubar);
        f.setSize(925, 430);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ket thuc chuong trinh
        f.setLayout(null);
        f.setVisible(true);//giup div hien thi
    }

    public static void main(String[] args) {
        new addBook();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int price = 0;
                
        if (e.getSource() == addBook) {

            pattern = Pattern.compile("^\\d+");
            boolean sx = pattern.matcher(priceField.getText()).matches();

            Books book = new Books();
            
            if(priceField.getText().equals("")){
                erroPrice.setText("Ban chua nhap Price");
            }else{
                if (sx == false) {         
                    erroPrice.setText("Price phải là số");                           
                } else {
                    erroPrice.setText("");
                    price = Integer.parseInt(priceField.getText());
                    truePrice = true;
                }
            }
                   
            if(idField.getText().equals("")){
                erroID.setText("Ban chua nhap ID");
            }else{
                trueID = true;
                erroID.setText("");
            }
            
            if(nameField.getText().equals("")){
                erroName.setText("Ban chua nhap Name");
            }else{
                trueName = true;
                erroName.setText("");
            }
            
            if(categoryField.getText().equals("")){
                erroCategory.setText("Ban chua nhap Category");
            }else{
                trueCategory = true;
                erroCategory.setText("");
            }
            
            if(conntentField.getText().equals("")){
                erroConntent.setText("Ban chua nhap Conntent");
            }else{
                trueConn = true;
                erroConntent.setText("");
            }
            
            if(authorField.getText().equals("")){
                erroAuthor.setText("Ban chua nhap Author");
            }else{
                trueAuthor = true;
                erroAuthor.setText("");
            }
            
            if(trueID && trueCategory && trueAuthor && trueConn && truePrice && trueName){
                book.setIdBook(idField.getText());
                book.setNameBook(nameField.getText());
                book.setConntentBook(conntentField.getText());
                book.setAuthor(authorField.getText());
                book.setCategory(categoryField.getText());
                book.setPrice(price);
                listBooks.add(book);
                
                idField.setText("");nameField.setText("");categoryField.setText("");authorField.setText("");priceField.setText("");conntentField.setText("");
                
                trueID = trueCategory = trueAuthor = trueConn = truePrice = trueName = false;
                
                File files = new File("listbooks");
                
                String tenFile = files.getAbsolutePath() + "\\" + book.getNameBook() + ".txt";
                
                File newBook = new File(tenFile);
        
                if (!newBook.exists()) {
                    try {
                        newBook.createNewFile();
                        JOptionPane.showMessageDialog(f, "Add Success!");
                        
                        FileWriter fw = new FileWriter(newBook);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        bw.write(book.getIdBook() + "\n");
                        bw.write(book.getNameBook()+ "\n");
                        bw.write(book.getAuthor()+ "\n");
                        bw.write(book.getCategory()+ "\n");
                        bw.write(book.getConntentBook()+ "\n");
                        bw.write(book.getPrice()+ "\n");
                        
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(addBook.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(f, "sach nay da ton tai");
                }
            }
        } else {
            
            try {
                new listbook().setVisible(true);
                f.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(addBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
