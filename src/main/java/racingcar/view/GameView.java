package racingcar.view;

public class GameView {

    public GameView() {
    }

    public void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
