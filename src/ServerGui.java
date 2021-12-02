import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerGui extends JFrame implements ActionListener {

    JTextField t1, t2;
    JLabel l1;
    JButton b1;

    public ServerGui() {

        l1 = new JLabel();
        l1.setText("Run Server");
        l1.setBounds(250, 50, 200, 50);
        l1.setFont(new Font(null, Font.PLAIN, 20));
        add(l1);

        t1 = new JTextField();
        t1.setText("Port Number");
        t1.setEditable(false);
        t1.setBounds(50, 150, 150, 30);
        t1.setCaretColor(Color.black);
        t1.setFont(new Font("null", Font.PLAIN, 15));
        add(t1);

        t2 = new JTextField();
        t2.setText("5000");
        t2.setEditable(false);
        t2.setBounds(250, 150, 300, 30);
        t2.setCaretColor(Color.black);
        t2.setFont(new Font("null", Font.PLAIN, 15));
        add(t2);

        b1 = new JButton("Start Server");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(200, 230, 175, 30);
        b1.setFocusable(false);
        b1.setFont(new Font(null, Font.PLAIN, 20));
        b1.addActionListener(this);
        add(b1);

        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(b1)) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int x = Integer.parseInt(t2.getText());
                        ServerSocket serverSocket = new ServerSocket(5000);
                        Server server = new Server(serverSocket);
                        server.startServer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            JOptionPane.showMessageDialog(null, "Server port is available for connections");
        }
    }

    public static void main(String[] args) {

        new ServerGui();

    }
}


