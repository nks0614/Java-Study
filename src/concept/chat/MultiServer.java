package concept.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
    public static final int PORT = 9000;  //서버 포트
    public static ArrayList<ChatHandler> clients; //가변적 배열로 쓰레드 변수 저장

    public static void main(String[] args) {
        try {
            //0. 쓰레드 저장 공간 할당
            clients = new ArrayList<ChatHandler>();
            //1. OS로부터 PORT 할당
            System.out.println("server start");
            ServerSocket server = new ServerSocket(PORT);

            //2. 무한 반복
            while (true) {
                //3. 접속대기. OS에게 Listen 상태로 알림
                Socket socket = server.accept();

                //4.쓰레드 생성
                ChatHandler thread = new ChatHandler(
                        socket,  //소켓
                        new DataOutputStream(socket.getOutputStream()),     // 출력 스트림
                        new DataInputStream(socket.getInputStream())
                );    // 입력 스트립

                //5. 쓰레드 저장
                clients.add(thread);

                //6. 쓰레드 동작
                thread.start();

                //현재 접속 중인 클라언트 갯수
                System.out.println("connect client cnt : " + clients.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
