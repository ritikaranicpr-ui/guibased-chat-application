import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Server extends JFrame {

  ServerSocket server;
  Socket socket;

  BufferedReader br;
  PrintWriter out;

  // declared components
    private JLabel heading = new JLabel("Server Area");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto", Font.PLAIN, 20);

  // Constructor..
  public Server() {
    try {
      server = new ServerSocket(5000);
      System.out.println("Server is ready to accept connection");
      System.out.println("Waiting...");
      socket = server.accept();

      br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream());
      
      createGUI();
      handleEvents();
      startReading();
      //startWriting();

    } catch (Exception e) {
      //e.printStackTrace();
    }
  }

  private void handleEvents() {
        messageInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
               // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
               // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                String contentToSend = messageInput.getText();
                messageArea.append("Me : " + contentToSend + "\n");

                out.println(contentToSend);
                out.flush();

                messageInput.setText("");
                messageInput.requestFocus();
            }

        }
    });
}

     private void createGUI() {
        //gui code...

        this.setTitle("Server Messager[END]");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //coding for component
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);
        heading.setIcon(new ImageIcon("slogo1.png"));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        messageArea.setEditable(false);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);
    

        //frame ka layout set karenge
        this.setLayout(new BorderLayout());

        //adding the compoents to frame
        this.add(heading, BorderLayout.NORTH);
        JScrollPane jScrollPane=new JScrollPane(messageArea);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(messageInput, BorderLayout.SOUTH);

        this.setVisible(true);
    }


  public void startReading() {
    // thread-read karke deta rhega
    Runnable r1 = () -> {
      System.out.println("reader started..");
      try {
        while (true) {
          String msg = br.readLine();
          if (msg.equals("exit"))

          {
            System.out.println("Client terminated the chat");
            JOptionPane.showMessageDialog(this,"Client Terminated the chat","Error !!",JOptionPane.ERROR_MESSAGE);
            messageInput.setEnabled(false);
            socket.close();
            break;
          }
          //System.out.println("Client : " + msg);
          messageArea.append("Client : " + msg+"\n");
        }
      } catch (Exception e) {
         //e.printStackTrace();
        System.out.println("Connection closed");
      }

    };
    new Thread(r1).start();
  }

  public void startWriting() {
    // thread- data user lega and then send krega client tak
    Runnable r2 = () -> {
      System.out.println("Writer started...");
      try {
        while (true && !socket.isClosed()) {

          BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
          String content = br1.readLine();

          out.println(content);
          out.flush();

          if (content.equals("exit")) {
            socket.close();
            break;
          }
        }
      } catch (Exception e) {
       //e.printStackTrace();
        System.out.println("Connection is closed");
      }
    };
    new Thread(r2).start();
  }

  public static void main(String[] args) {
    System.out.println("This is server...going to start server");
    new Server();
  }

}