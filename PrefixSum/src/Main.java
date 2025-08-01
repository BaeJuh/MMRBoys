import java.util.Arrays;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        int[] coins = {2, 3, 5, 10};
        int change = 10;
//        int change = 540;

        int events = changeEventCounter(coins, change);
        System.out.println(events);
    }

    public static int changeEventCounter(int[] coins, int change) {
        int[] tabulation = new int[change + 1];
        tabulation[0] = 1; // 0원을 만들기 위한 경우의 수는 1개

        for (int coin: coins) {
            for (int i = coin; i <= change; i++) { // 동전의 크기 부터 시작해서, 1씩 증가하면서 모두 채워야함
                tabulation[i] += tabulation[i - coin];
            }

//            for (int i = coin; i <= change; i+=coin) { // 동전의 크기 부터 시작해서, 1씩 증가하면서 모두 채워야함
//                tabulation[i] += 1;
//            }
        }
        System.out.println(Arrays.toString(tabulation));
        return tabulation[change];
    }
}