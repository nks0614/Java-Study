package concept.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static final int PORT = 9000;  //서버 포트
    public static final String ServerIp ="127.0.0.1";
    public static void main(String[] args) {
        try {
            //1.서버 접속
            Socket socket = new Socket(ServerIp,PORT);
            System.out.println("connected");

            //2. 입력 스트림
            InputStream is = socket.getInputStream();
            DataInputStream in = new DataInputStream(is);

            //3. 출력 스트림
            OutputStream os = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(os);

            //4. 키보드 입력 스트림
            Scanner sc = new Scanner(System.in);

            //5.출력 쓰레드 생성
            Thread sendThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //1. id 서버 전송
                    System.out.print("input id : ");
                    String msg = sc.nextLine();
                    try {
                        out.writeUTF(msg);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //2. 채팅 데이터
                    while(true) {
                        try {
                            System.out.print("msg : "); //채팅 입력 대기
                            msg = sc.nextLine();       //채팅 데이터 수신
                            out.writeUTF(msg);          //채팅 데이터 서버 전송
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            });
            //6. 입력 쓰레드 생성
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //1. 서버 데이터 수신->화면에 출력
                    while(true) {
                        try {
                            String msg = in.readUTF(); //서버 데이터 수신
                            System.out.println(msg); //화면에 출력
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            });
            //7. 쓰레드 시작
            sendThread.start();
            readThread.start();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
