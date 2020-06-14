package lesson01.competitor;

public class Human extends Humanoid {

    public Human(String name) {
        super("Человек", name, 4000, 1);
    }

    public Human(String name, int maxDistanceRun, int maxDistanceJump, int superHeight) {
        super("Человек", name, maxDistanceRun, maxDistanceJump);
    }
}
