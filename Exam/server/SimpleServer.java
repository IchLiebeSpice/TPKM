import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
 
	static Scanner scanner = new Scanner(System.in);
 
    private static void reverseIt(char[] chars) {
        for (int j = chars.length - 1; j >= 0; j--) {
            
        }
    }
}
	
    public static void main(String[] args) {
        Socket s = null;
        ServerSocket servSocket = null;
        PrintStream ps = null;
		BufferedReader bufferedReader = null;
		InputStreamReader isr = null;
        int port = 8030;
        try {
            servSocket = new ServerSocket(port);
            s = servSocket.accept();
			isr = new InputStreamReader(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
			bufferedReader = new BufferedReader(isr);
            System.out.println("Client connected [" + s.getInetAddress() + "]");
			String msg = bufferedReader.readLine();
			for (int i = 0; i < msg; i++) {
				String subInt = scanner.nextLine();
				reverseIt(subInt.toCharArray());
			}
			int reversemsg = reverseIt(msg);
            ps.println("ReversedMsg: " + reversemsg + " C: ");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ps.close();
            try {
                s.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                servSocket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
