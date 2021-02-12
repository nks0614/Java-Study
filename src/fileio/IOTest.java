package fileio;

import java.io.*;

public class IOTest {

    public static final String PATH = "test.txt";

    public static void main(String[] args) {

        try{

            File f = new File(PATH);

//            createFile(f);
//            writeFile("2");
            readFile();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void createFile(File f){
        try{
            if(!(f.exists() || f.isFile())){
                if(f.createNewFile()) {
                    System.out.println("성공");
                }else{
                    System.out.println("실패");
                }
            }else{
                System.out.println("이미 존재하는 파일입니다.");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String s){
        try{
            BufferedOutputStream bs = new BufferedOutputStream(
                    new FileOutputStream(PATH, true)
            );
            bs.write(s.getBytes());
            System.out.println("작성되었습니다. 작성된 내용 : "+ s);
            bs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFile(){
        try{
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(PATH)
            );

            byte[] buffer = new byte[bis.available()];
            while(bis.read(buffer) != -1){}

            System.out.println(new String(buffer));

        }catch(Exception e){

        }
    }

}
