package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //1.맨처음에 스태틱영역에 객체 저장

    public static SingletonService getInstance() {
        return instance;
        //2.저장된 객체를 사용 => 이는 항상 같은 인스턴스만 호출하게된다
    }
    private SingletonService() {
//        3.생성자를 private로 설정함으로써 외부에서 new 키워드를 사용못하게 막는다
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
