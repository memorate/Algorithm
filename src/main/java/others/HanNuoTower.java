package others;

/**
 * 汉诺塔
 *
 * @author Anchor
 * @date 2021-04-26 10:12
 */
public class HanNuoTower {
    int counter = 0;

    public static void main(String[] args) {
        new HanNuoTower().moveDish(3, 'A', 'B', 'C');
    }

    public void moveDish(int level, char from, char inter, char to) {
        if (level == 1) {
            print(from, to);
        } else {
            moveDish(level - 1, from, to, inter);
            print(from, inter);
            moveDish(level - 1, inter, from, to);
        }
    }

    public void print(char from, char to) {
        System.out.println("第 " + ++this.counter + " 次移动：" + from + " --> " + to);
    }
}
