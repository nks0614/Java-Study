package concept.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatHandler extends Thread{
    public final Socket socket ;
    public final DataOutputStream out;
    public final DataInputStream in;
    public String name;

    public ChatHandler(Socket socket, DataOutputStream out , DataInputStream in) {
        this.socket = socket;
        this.out = out;
        this.in = in;

    }
    @Override
    public void run() {
        String temp = "";
        try {
            //1. 클라언트 id를 저장
            temp = in.readUTF(); //엔터 기준 한글 utf-8 read
            System.out.println("client id : " + temp);
            name = temp;

            //2. 무한 반복
            while (true) {
                //3. 채팅 데이터 저장
                temp = in.readUTF();

                //4. 모든 클라언트에 메세지 전달
                final String msg = name + " : " + temp;
                for (ChatHandler handler : MultiServer.clients) {
                    handler.out.writeUTF(msg);
                    System.out.println(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
