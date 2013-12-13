package com.company;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    WebClient client = new WebClient(BrowserVersion.CHROME); //webClienti არის კლასი რომელიც ტვირთავს გვერდებს
                    HtmlPage page=null;    //ეს არის გვერდის კლასი
                    try {
                        page = client.getPage("http://forum.ge/?act=Login&CODE=00");   //გვერდის კალსის ობიექტს ვანიჭებთ გვერდს

                    System.out.println(page.getTitleText());    // დავაბეჭდინეთ გვერდის სახელი

                    HtmlForm form = page.getFormByName("LOGIN");  //   ეს არის html ფორმა
                    form.getInputByName("UserName").setValueAttribute("Steve-Jobs");   //ეს არის დაითრიე შესაყვანი სახელის მიხედვით და  ჩაწერე ტექსტი
                    form.getInputByName("PassWord").setValueAttribute("stiviko1");

                        page= form.getInputByName("submit").click(); // page-ს მიენიჭა წამოღებული input-ზე დაკლიკული

                    if(page.getTitleText().equals("Please stand by...")){     //თუ გვერდის სახელი ემთხვევა გადაცემულ ინფორმაციას
                        System.out.println("ავტორიზაცია წარმატებულია");
                    }

                        page = client.getPage("http://forum.ge/?f=25&showtopic=34596055");  //  გადადის თემაზე



                    form = page.getFormByName("REPLIER");  //წამოიგე  პასუხის  გამცემი
                    form.getTextAreaByName("Post").setText("მე                                                           ვარ ბოტი                         ");   //ტექსტი ჩავწერეთ

                        page= form.getInputByName("submit").click();         // დაკლიკვა

                    System.out.println(page.getTitleText());


                        Thread.sleep(1000*60*10);
                    } catch (Exception e ) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }


            }
        }).start();




    }
}
