public class Main {

    static int i = 0;

    static void loop() {
        for(int j = 0; j < 10; j++) {
            i++;
        }
    }

    public static void main(String[] args) {
        new Thread(Main::loop).start();
        new Thread(Main::loop).start();
        System.out.println(i);
    }
}
