package programmers;

public class CaesarPassword {

    public static void main(String[] args) {
        System.out.println(solution("a B c", 30));
    }

    public static String solution(String s, int n) {
        String answer = "";
        int ch;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                ch = s.charAt(i);

                if(ch > 64 && ch < 91){ //소문자
                    ch += n;
                    if(ch > 90){
                        ch = 65 + ((ch-91) % 26);
                    }
                }
                else{ //대문자
                    ch += n;
                    if(ch > 122){
                        ch = 97 + ((ch-123) % 26);
                    }
                }
                answer += Character.toString(ch);
            }
            else{
                answer += " ";
            }
        }

        return answer;
    }

}
