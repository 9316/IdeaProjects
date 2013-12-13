package com.company;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**    ნიკა ფანოზიშვილი
 * Created with IntelliJ IDEA.
 * User: Nika
 * Date: 11/28/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Magti {

    private JComboBox ინდექსიComboBox;
    private JTextField ნომერიTextField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;
    private JTable table1;
    private JTextArea textArea1;
    private JLabel label56;
    public static ImageIcon loading;
    public static JFrame frame = new JFrame("მაგთიკომი");
      public static JLabel label = new JLabel("მომხმარებელი");
      public static JLabel label1 = new JLabel("პაროლი");
      public static JTextField filed = new JTextField();
      public static JPasswordField filed2 = new JPasswordField();
      public static JButton button = new JButton("შესვლა");
    public static JLabel label3 = new JLabel();
    private static HtmlForm form;         //HTML ფორმა
    private static WebClient bee;           //ვებკლიენტი
    private static HtmlPage sendsms;        //სმს-ის გაგზავნის გვერდი
    private static HtmlImage captcha;         //კაპჩას სურათი
    private static HtmlSelect index;         //html combobox
    private static HtmlOption option;         //ჩამონათვალი

    private static String os;   //ოპერაციული სისტემის სახელი
    private static String userName; //მომხმარებლის სახელი
    private static File beeDir;    //ამ პროგრამის ფოლდერი სადაც ინახება ნომრების სია და captcha - სურათი
   // public static String captchaloc;  //ამ საქაღალდეში(beeDir) მოთავსებული captcas სურათის მისამართი
    public Scanner scan;
    public static String numFileLoc; //ნომრების შესანახი
    public static Formatter out;      //ტექსტის ფორმატირების კლასი
    public static DefaultTableModel model;   //ცხრილის მოდელი
    public static File beeFile;      //ფაილის კლასი
    public static WebClient client;      //გვერდების ჩამთვირთავი კალსი
    public static HtmlPage page;      //გვერდის კლასი





    public static void main(String[] args) {


       frame.setSize(new Dimension(330, 120)); //მთავარი ფანჯრის ზომა
        frame.setLayout(new GridLayout(3, 3)); //layout-ბის დაყენება
        frame.add(label);
        frame.add(filed);
        frame.add(label1);
        frame.add(filed2);
        frame.add(label3);
        frame.add(button);
        frame.setResizable(false);  //მზარდი იყოს თუ არა მთავარი ფანჯარა
        frame.setLocationRelativeTo(null);  //ფანჯრის ცენტრში განთავსება
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //გამოსვლა
        frame.setVisible(true);    //ფანჯრის გამოჩენა



        button.addActionListener( new ActionListener() {    //button-ის გადატვირთვა
            @Override
            public void actionPerformed(ActionEvent e) {

                loading = new ImageIcon(Magti.class.getResource("484.gif"));  //ანიმაციის ატვირთვა
                label3.setIcon(loading);    //ლეიბელ 3-ზე ანიმაციის დაყენება
                client = new WebClient(BrowserVersion.CHROME);  //Client-ი არის ვებ გვერდის ჩამტვირთავი კლასი
                page =null;


                try {
                    new SwingWorker<Void, String>() {  //სვინგვორკერი არის ინტერფეისი გადასატვირთი კლასი რომელიც ხელს უწყობს პროგრამას სწრაფად მუშაობაში
                        @Override
                        protected Void doInBackground() throws Exception {
                            page = client.getPage("http://magtifun.ge");  //გვერდის კლას გავადცემთ მისამართს


                            HtmlForm form = page.getFormByName("user_action");  //Html forma

                            form.getInputByName("user").setValueAttribute(filed.getText());  //დაიჭირე შესაყვანი სახელის მიხედვით და ჩაწერე ტექსტი
                            form.getInputByName("password").setValueAttribute(filed2.getText());
                            page = form.getInputByValue("შესვლა").click();


                            if(!page.getTitleText().equals("MagtiFun | SMS")){ //თუ ემთხვევა
                                JOptionPane.showMessageDialog(null,"სახელი ან პაროლი არასწორია ", "ინფორმაცია",JOptionPane.INFORMATION_MESSAGE);
                                frame.setContentPane(new Magti().panel1);
                                frame.setVisible(false);

                            }
                            else{
                            info();
                            }
                            return null;  //To change body of implemented methods use File | Settings | File Templates.
                        }
                    }.execute();


                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            };
        });
               }




                       public static void info(){
                           try{
                    frame.setContentPane(new Magti().panel1);
                    frame.setVisible(true);
                    frame.setSize(new Dimension(200,50));
                    frame.setLocationRelativeTo(null);
                               frame.setResizable(false);  //მზარდი იყოს თუ არა ფანჯარა

                               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                               frame.pack();



                    os=System.getProperty("os.name").toLowerCase();    //ოპერაციული სისტემის სახელის მინიჭება
                    userName = System.getProperty("user.name");         // მომხმარებლის სახელის დათრევა
                    System.out.println(System.getProperty("user.home")); //მომხმარებლის საქაღალდის დათრევა
                    System.out.println(os);

                    if(os.contains("lin")) {   //თუ შეიცავს lin

                            //     UIManager.setLookAndFeel(new GTKLookAndFeel());
                            beeDir = new File("/home/" + userName + "/.magti");  //ფოლდერის მისამართი

                            if(!beeDir.exists()){    //თუ არ არის ესეთი ფოლდერი
                                beeDir.mkdir();      //შექმენი
                            }


                           // captchaloc = "/home/" +userName+ "/.beesms/captcha.jpg";   //ქაფჩას სურათის და ნომრების  მისამართი
                            numFileLoc = "/home/" +userName+ "/.magti/numbers.txt";

                        }
                    else if(os.contains("mac")){

                            //UIManager.setLookAndFeel(new NimbusLookAndFeel());
                            beeDir = new File("/Users/" + userName + "/.magti");

                            //captchaloc = "/Users/" +userName+ "/.beesms/captcha.jpg";
                            numFileLoc = "/Users/" +userName+ "/.magti/numbers.txt";



                    }

                    else if(os.contains("win")){

                            UIManager.setLookAndFeel(new WindowsLookAndFeel());
                            beeDir = new File(System.getProperty("user.home") + "\\magti");
                            if(!beeDir.exists()){
                                beeDir.mkdir();

                            }
                           // captchaloc = System.getProperty("user.home") + "\\beesms\\captcha.jpg";
                            numFileLoc = System.getProperty("user.home") + "\\magti\\numbers.txt";

                        }


                    beeFile = new File(numFileLoc);   //ნომრების ფაილი
                    if(!beeFile.exists()){

                            beeFile.createNewFile();
                        }


                } catch (Exception e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

}
        public Magti (){
            textArea1.setLineWrap(true);     //სიტყევბის გადამტანი extArea-ში
            textArea1.setWrapStyleWord(true);  //როგორი სტილის მიხედვით გადაიტანოს ამ შემთხვევაში გადააქვს სიტყვის მიხედვით
            final String [] indexArray = {"592","568", "571", "597", "579", "574", "577", "593", "555", "558",
                    "557", "514", "599", "595", "591", "598", "551", "596", "570"};       //ნომრების მასივი



            model = new DefaultTableModel();    //მოდელს ვუთითებთ ახალი მოდელის ობიექტს

            table1.setModel(model);           //ცხრილის მოდელზე დაფუძნება
            model.addColumn("სახელი");
            model.addColumn("ნომერი");
            numFileLoc = System.getProperty("user.home") + "\\magti\\numbers.txt";
            try{

                System.out.println(numFileLoc);
                Scanner s = new Scanner(new File(numFileLoc))   ;   //ნომრების ფაილი numfileLoc

                while(s.hasNext()){
                    String a,b;
                    a=s.nextLine(); //es jer kuTxulobs saxels
                    b=s.nextLine(); //ბ კითხულობს ნომერს
                    String [] info = {a,b};    // მასივში ვწერრთ
                    model.addRow(info);      //მოდელზე ვამატებთ სტრიქონს ინფო მასივში შემავალი ინფორმაცია
                }

            }
            catch (Exception e){

                e.printStackTrace();
            }


            model.addTableModelListener(new TableModelListener() {   // მოდელის მსმენელი (listnere რომელიც ელოდება  მოქმედებას
                @Override
                public void tableChanged(TableModelEvent e) {
                    System.out.println("Table changed");

                    try {
                        out = new Formatter(new File(numFileLoc)); // ფორმატერის ობიექტს გადავცემთ ნომრების ფაილს
                        for(int i=0; i<model.getRowCount(); i++){     //მოდელის სტრიქონების რაოდენობამდე

                            out.format(model.getValueAt(i, 0).toString() + "\n" + model.getValueAt(i, 1).toString() + "\n");  //ფაილში აანხლებს მოდელში ყოველ ჯერზე შეცვლილ ინფორმაციას ( getvalueit მოდელიდან მოაქ ჯერ სახელი და მერე ნომერი და გადაყავს სტრინგში )
                        }
                        out.close();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            });
            table1.addMouseListener(new MouseAdapter() { //ცხრილზე დაჭერა ანუ მსემენლი
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    for(int i=0; i<indexArray.length; i++){  ///ციკლი მასივის ზომამდე
                        if(model.getValueAt(table1.getSelectedRow(),1).toString().substring(0,3).equals(indexArray[i])){  //მოდელიდან მოაქვს მნიშვნელობა ცხრილის მონიშნული სტრიქონიდან მეორე სტვეტს სტრინგში გადაგვყავს და ვიყენებთ პირველ 3 ციფრს  თუ ემთხვევა მასივის რომელიმე წევრს
                            ინდექსიComboBox.setSelectedIndex(i);  //ამოირჩიოს დამთხვეული წევრი
                           ნომერიTextField.setText(model.getValueAt(table1.getSelectedRow(),1).toString().substring(3,9));  //ჩაწეროს ინდექსის გარეშე ნომერი
                        }
                    }

                }
            });
            ინდექსიComboBox.setModel(new DefaultComboBoxModel(indexArray));  //comboboxs    ვაფუძნებთ მოდელზე და მასივზეა დაფუძნებული

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(textArea1.getText().length()>160 ){
                        JOptionPane.showMessageDialog(null, "ლიმიტია 160 მდე","შეცდომა", JOptionPane.WARNING_MESSAGE );
                    }
                    else{
                        try {
                            sendsms = client.getPage("http://www.magtifun.ge/index.php?page=2&lang=ge");
                        } catch (IOException e1) {
                            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }

                       ინდექსიComboBox.getSelectedIndex();

                        HtmlInput inputRecipient = (HtmlInput) sendsms.getElementById("recipient"); //HtmlInput-ის ობიექტს ენიჭება გვერდიდან წამოღებული ელემენტი Id-ის მიხედვით
                        String tmpStr = ინდექსიComboBox.getSelectedItem().toString() + ნომერიTextField.getText();//დროებითი სტრინგი სრული ნომრისთვის
                        System.out.println(tmpStr);       //ლოგირება
                        inputRecipient.setValueAttribute(tmpStr);   //ინპუტზე ნომრის სტრინგის ჩაწერა
                        HtmlTextArea text = (HtmlTextArea)sendsms.getElementById("message_body");    //HtmlTextAreas-ს ობიექტს ენიჭება გვერდიდან წამოღებული ტექსტარეა რომლის იდიცაა message_body
                        text.setText(textArea1.getText());                //ტექსტის ჩასმა ტექსტარეაში
                        HtmlInput sendButton = (HtmlInput) sendsms.getFirstByXPath("//input[@value='გაგზავნა']");  // HtmlInput -ის ობიექტს ენიჭება XPATH-iT მოძებნილი ელემენტი
                        try {
                            HtmlPage pageSent =  sendButton.click();     //ღილაკზე დაკლიკვა

                            if(pageSent!=null){
                                JOptionPane.showMessageDialog(null,"შეტყობინება გაიგზავნა","ინფორმაცია",JOptionPane.INFORMATION_MESSAGE);
                            }

                            textArea1.setText(" ");
                        } catch (IOException e1) {
                            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }

                        // form.getInputByValue("გაგზავნა")


                    }

                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ნომერიTextField.getText().length()==6){
                        String [] newData = {"", ინდექსიComboBox.getSelectedItem().toString()+ ნომერიTextField.getText()};
                        model.addRow(newData);
                    }
                    else{
                        String [] newData = {"",""};
                        model.addRow(newData);
                    }
                }
            });
            textArea1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    label56.setText(textArea1.getText().length() + "/160-დან");

                    if (textArea1.getText().length() >= 160) {
                       label56.setText("<html><font color='red'>" + label56.getText() + "</font></html>");
                    }
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.removeRow(table1.getSelectedRow());
                }
            });
    }


}



















