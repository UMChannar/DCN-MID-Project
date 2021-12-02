import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientGui extends JFrame implements ActionListener {

    JLabel l1;
    JPanel p1;
    JTextArea ta1;
    JTextField t1;
    JButton b1;

    public ClientGui() {

        p1 = new JPanel();
        p1.setBounds(50,175,500,400);
        add(p1);

        l1 = new JLabel();
        l1.setText("Chat Window");
        l1.setFont(new Font(null, Font.BOLD, 30));
        l1.setBounds(200,75,400,50);
        add(l1);

        ta1 = new JTextArea(26,40);
        ta1.setBounds(50,175,500,400);
        p1.add(ta1);

        t1 = new JTextField();
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setCaretColor(Color.black);
        t1.setBounds(50, 600, 400, 30);
        t1.setFont(new Font("null", Font.PLAIN, 20));
        add(t1);

        b1 = new JButton("Send");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(450, 600, 100, 30);
        b1.setFocusable(false);
        b1.setFont(new Font(null, Font.PLAIN, 20));
        b1.addActionListener(this);
        add(b1);

        setSize(600, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(b1)) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Your Username: ");
                String username = scanner.nextLine();
                Socket socket = new Socket(inetAddress, 5000);
                Client client = new Client(socket, username);
                client.listenForMessage();
                client.sendMessage();
            } catch (IOException e) {

            }
        }

    }

    public static void main(String[] args) {
        new ClientGui();
    }
}
