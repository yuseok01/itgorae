package Day8_큐;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
 
class RealPizza {
 
    int num;
    int cheese; // 치즈
 
    // 피자넘버
    public RealPizza(int num, int cheese) {
        this.num = num;
        this.cheese = cheese;
    }
 
    @Override
    public String toString() {
        return "RealPizza [num=" + num + ", cheese=" + cheese + "]";
    }
 
}
 
public class 큐_피자2 {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테케갯수
 
        Queue<RealPizza> pizza = new LinkedList<>();
        Queue<RealPizza> fire = new LinkedList<>(); 
 
        for (int tc = 1; tc <= T; tc++) {
 
            int N = sc.nextInt();
            int M = sc.nextInt();
 
            for (int i = 1; i < M + 1; i++) {
                RealPizza rp = new RealPizza(i, sc.nextInt()); // 피자를 만들어줌
                pizza.offer(rp); // q에 바로바로 추가추가
            }
 
            List<Integer> perfectpizza = new ArrayList<>(); // 완벽한 피자
 
            // 화덕에서 도는 상황 (화덕 갯수만큼)
            for (int i = 0; i < N; i++) {
                fire.offer(pizza.peek()); // 추가해주고
                pizza.remove(); // 없애줘
            }
             
            // 얼마나 돌지 모르니까 일단 돌아
            //화덕이 빌때까지!!!!!!!!
            while (!fire.isEmpty()) {
                // 만약 치즈가 1이 되지 않앗다면
                while (fire.peek().cheese/2 > 0) {
                    // 해당 peek값을 2로 나누고 더해준다음에
                    // 왼쪽은 해당 피자번호, 오른쪽이 바뀌는 치즈양
                    // 이 피자를 뒤에 더해주고
                    fire.offer(new RealPizza(fire.peek().num, fire.peek().cheese/2));
                    fire.remove(); // 지워주셈
                }
                // 치즈가 0이라면 while 나오면
                // 해당 피자는 빼줘야해
                // 해당 번호에 맞는 인덱스에 제거하는 걸 넣어준다.
                perfectpizza.add(fire.peek().num);
                fire.remove(); // 빼준다.
                 
                // pizza 배열이 비어있지 않다면 추가해야해
                if (!pizza.isEmpty()) {
                    fire.offer(pizza.peek()); // 남는 걸 화덕에 넣어준다.
                    pizza.remove();
                }
            }
             
            // 젤끝인덱스에 찍어줌.
            System.out.println("#" + tc + " " + perfectpizza.get(M-1));
 
        } // 테케
    }// main
}