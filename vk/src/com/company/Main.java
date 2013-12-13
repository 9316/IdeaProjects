package com.company;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        WebClient client =  new WebClient(BrowserVersion.CHROME);
        HtmlPage page=null;


        try {
            page = client.getPage("http://www.facebook.com");

            System.out.println(page.getTitleText());

            HtmlForm form = (HtmlForm) page.getElementById("login_form");
            form.getInputByName("email").setValueAttribute("loria-2012@mail.ru");
            form.getInputByName("pass").setValueAttribute("saburtalo16");
            page = form.getInputByValue("Log In").click();
            System.out.println(page.getTitleText());

            HtmlTextArea statusText = (HtmlTextArea) page.getElementByName("xhpc_message_text");
            statusText.click();
            statusText.setText("I'm a robot");
            HtmlButton post = (HtmlButton) page.getFirstByXPath("//button[@id=\"u_jsonp_3_4\"]/div/div[4]/div/ul/li[2]/button");
            post.click();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
