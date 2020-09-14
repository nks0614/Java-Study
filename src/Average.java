public class Average {

    public static void main(String[] args) {
        int[] arr = {4,4,4,4,4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        int sum = 0;

        for(int i : arr){
            sum += i;
        }

        return (double)sum / (double)arr.length;
    }

}
