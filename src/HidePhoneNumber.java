public class HidePhoneNumber {

    public static void main(String[] args) {
        System.out.println(Solution("0104444999"));
    }

    public static String Solution(String phone){
        String changeNum = "";

        if(phone.length() >= 4){
            for(int i = 0; i < phone.length(); i++){
                if(i < phone.length()-4){
                    changeNum += "*";
                }
                else{
                    changeNum += phone.charAt(i);
                }
            }
        }

        return changeNum;

    }


// 다른 사람 풀이 2개
//    public String solution(String phone_number) {
//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
//    }
    
// 이건 정규식 쓰는거
//    public String solution(String phone_number) {
//        return phone_number.replaceAll(".(?=.{4})", "*");
//    }

}
