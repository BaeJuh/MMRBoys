import java.util.Arrays;
import java.util.List;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        n.stream()
                .filter((num) -> num % 2 == 1)
                .forEach(System.out::println);
            // stream 병렬 처리 하기 위함

        List<String> a = Arrays.asList("a", "b", "c");
        a.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = nums.stream()
                .filter((num) -> num % 2 == 0)
                .reduce(0, (acc, cur) -> acc + cur);
    }
}