package org.example;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import org.example.call.PropSetter;
import org.example.call.java.PrinterCall;
import org.example.interfac.OnFinishLoadListener;
import org.example.util.LogSleeper;
import org.example.util.PathUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author chrils
 * @description JxBrowser进行桌面应用开发
 * @see OnFinishLoadListener
 * @see org.example.call.java.CallJava
 * @see PropSetter
 */
public class Main {
    public static void main(String[] args) {
        // 1.UI架构（swing）
        Browser browser = new Browser();
        JComponent browserView = new BrowserView(browser);
        JFrame frame = new JFrame("JxBrowser");
        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String path = PathUtil.getResourceURI()
                .sourceName("index.html")
                .withFileStrategy()
                .build();
        System.out.println(path);
        // 2.监听控制台输出
        browser.addConsoleListener(consoleEvent -> {
            System.out.println(consoleEvent.getMessage());
        });
        // 3.JS调用Java代码
        browser.addLoadListener((OnFinishLoadListener) event -> {
            if (event.isMainFrame()) {
                JSValue window = browser.executeJavaScriptAndReturnValue("window");
                PropSetter.setCall(window, new PrinterCall());
            }
        });
        browser.loadURL(path);
        frame.setVisible(true);
        LogSleeper.sleep(5000);
        // 4.Java调用JS代码
        browser.executeJavaScript("vueInstance.formDatas.push(9999)");
    }

}