package pkumooc;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.fluent.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author liuwenchen
 * @create 2020-07-30 16:13
 */

public class HttpSuggestion extends JFrame {
    JTextField txtInput = new JTextField();
    JList<String> lstSuggestion = new JList<>();

    public HttpSuggestion() {
        super("auto suggestion");
        getContentPane().add(BorderLayout.NORTH, txtInput);
        getContentPane().add(BorderLayout.CENTER, new JScrollPane(lstSuggestion));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                new Thread(() -> {
                    try {
                        String word = txtInput.getText();
                        String[] suggestion = fetchSuggestion(word);
                        SwingUtilities.invokeLater(() -> {
                            lstSuggestion.removeAll();
                            lstSuggestion.setListData(suggestion);
                            lstSuggestion.updateUI();
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }).start();
            }
        });
        lstSuggestion.addListSelectionListener(e -> txtInput.setText(lstSuggestion.getSelectedValue()));
    }

    public static void main(String... args) {
        // String word = "人";
        // fetchSuggestion(word);
        SwingUtilities.invokeLater(() -> new HttpSuggestion());
    }

    public static String[] fetchSuggestion(String word)
            throws UnsupportedEncodingException, ClientProtocolException,
            IOException {
        if (word == null || word.length() == 0) {
            return new String[0];
        }

        String url = "http://suggestion.baidu.com/su?wd="
                + URLEncoder.encode(word, "utf-8");
        url += "&rnd=" + Math.random();

        String content = Request.get(url)
                .addHeader("cookie", "BDUSS=Aadasdfsfee").execute()
                .returnContent().asString();

        System.out.println(content);

        String[] sug = content.replaceAll(".*,s:\\[([^\\]]*)\\].*", "$1")
                .replaceAll("\"", "").split(",");
        return sug;
    }
}