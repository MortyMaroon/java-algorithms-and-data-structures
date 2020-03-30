package Chap05.Works;

public class JosephusFlaviusProblem {
    public static void main(String[] args) {
        System.out.println(solveProblem(7,3,1));
    }

    public static String solveProblem(int peopleCount, int count, int peopleNumber) {
        CyclicList cyclicList = new CyclicList();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = peopleCount; i > 0; i--) {
            cyclicList.insert(i);
        }
        while (cyclicList.current.getData() != peopleNumber) {
            cyclicList.step();
        }
        while (!cyclicList.isEmpty()) {
            for (int i = 1; i <= count; i++) {
                cyclicList.step();
            }
            stringBuilder.append(cyclicList.current.getData());
            cyclicList.delete(cyclicList.current);
        }
        return stringBuilder.toString();
    }
}
