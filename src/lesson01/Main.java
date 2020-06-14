package lesson01;


import lesson01.competitor.*;
import lesson01.obstacle.Obstacle;
import lesson01.obstacle.RunningTrack;
import lesson01.obstacle.Wall;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {
                new Human("Василий Пупкин"),
                new Robot("Робот", "Вертер"),
                new Cat("Барсик"),
                new Chicken("Пеструшка"),
                new Human("Усейн Болт", 10000, 3,7)
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new RunningTrack(1000),
                new Wall(2),
                new RunningTrack(3000),
                new Wall(3),
                new RunningTrack(5000)
        };

        int numObstacle = 1;

        for (Obstacle obstacle : obstacles) {
            System.out.println("Препятствие №: " + numObstacle);
            for (Competitor competitor : competitors) {
                if (competitor.isOnDistance()) {
                    obstacle.doIt(competitor);

                }
            }
            numObstacle++;
        }
        System.out.println();
        System.out.println("Гонка закончилась!");
        System.out.println();
        System.out.println("Всю дистанцию прошли:");
        for (Competitor competitor : competitors) {
            if (competitor.isOnDistance()) {
                competitor.info();
            }
        }
        System.out.println();
        System.out.println("Всю дистанцию пройти не смогли:");
        for (Competitor competitor : competitors) {
            if (!competitor.isOnDistance()) {
                competitor.info();
            }
        }

    }
}
