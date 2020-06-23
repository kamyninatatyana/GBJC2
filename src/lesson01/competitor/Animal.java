package lesson01.competitor;

public class Animal implements Competitor {
    String type;
    String name;

    int maxDistanceRun;
    int maxDistanceJump;

    boolean onDistance;

    Animal(String type, String name, int maxDistanceRun, int maxDistanceJump) {
        this.type = type;
        this.name = name;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceJump = maxDistanceJump;
        this.onDistance = true;

    }

    @Override
    public void run(int distance) {
        if (distance == 0) {
            System.out.printf("%s %s не умеет бегать!\n", type, name, distance);
        }
        else if (distance <= maxDistanceRun) {
            System.out.printf("%s %s успешно пробежал(а) %d м!\n", type, name, distance);
        } else {
            System.out.printf("%s %s не удалось пробежать %d м!\n", type, name, distance);
            System.out.printf("%s %s сошел с дистанции\n", type, name);
            onDistance = false;
        }

    }

    @Override
    public void jump(int height) {
        if (height == 0) {
            System.out.printf("%s %s не умеет прыгать!\n", type, name, height);
        }
        else if (height <= maxDistanceRun) {
            System.out.printf("%s %s успешно прыгнул(а) на %d м!\n", type, name, height);
        } else {
            System.out.printf("%s %s не смог(ла) прыгнуть на %d м!\n", type, name, height);
            System.out.printf("%s %s сошел с дистанции\n", type, name);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.printf("%s %s\n", type, name);

    }
}
