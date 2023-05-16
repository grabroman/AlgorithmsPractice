package v1;

import v1.figuers.Circle;
import v1.figuers.Figure;
import v1.figuers.Square;
import v1.figuers.ScaleneTriangle;
import v1.figuers.IsoscelesTriangle;
import v1.figuers.EquilateralTriangle;


/**
 * Class that shows work of figure classes according to the task
 *
 * @author Roman Grabovetskyi
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Figure[] figure = new Figure[10];
        final int MAX = 5;
        int choice;
        for (int i = 0; i < 10; i++) {
            choice = ((int) Math.ceil(Math.random() * 3));
            switch (choice) {
                case 1:
                    figure[i] = new Circle().generateRandomFigure();
                    break;
                case 2:
                    figure[i] = new Square().generateRandomFigure();
                    break;
                case 3:
                    figure[i] = new ScaleneTriangle().generateRandomFigure();
                    break;
                case 4:
                    figure[i] = new IsoscelesTriangle().generateRandomFigure();
                    break;
                case 5:
                    figure[i] = new EquilateralTriangle().generateRandomFigure();
                    break;
            }
        }
        System.out.println("First array");
        for (Figure el : figure) {
            System.out.println(el);
        }
        for (int i = 0; i < 10; i++) {
            choice = ((int) (Math.random() * MAX));
            figure[i].makeBigger(choice);
        }
        System.out.println("Second array");
        for (Figure element : figure) {
            System.out.println(element);
        }
        System.out.println("Sorted array");
        for (int i = figure.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((int) figure[j].getSquareArea() < (int) figure[j
                        + 1].getSquareArea()) {
                    Figure f = figure[j];
                    figure[j] = figure[j + 1];
                    figure[j + 1] = f;
                }
            }
        }
        for (Figure element : figure) {
            System.out.println(element);
        }
    }
}
