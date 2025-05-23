import java.util.Arrays;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 4};

        solution(arr, 5);
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int startPos = 0;
        int endPos = 0;

        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
//                System.out.println(sum);
                if (sum == k) {
                    startPos = i;
                    endPos = j;

                    answer = new int[]{startPos, endPos};
                    break;
                }
            }
            System.out.println(Arrays.toString(answer));
        }

        return answer;
    }
}