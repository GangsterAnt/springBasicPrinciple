package hello.core.singleton;

public class SingletonService {

    /*
    자기 자신을 내부 1개 스태틱으로 갖는다, static 이므로 jvm 에 1개만 올라가고, 이을 통해 생성자를 호출한게 jvm에 1개 기본으로 올라가게 된다.
    */
    private static final SingletonService instance = new SingletonService();

    private SingletonService() {

    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
