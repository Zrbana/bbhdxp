package java7.daily.learning.prac;

import java.util.Scanner;

/**
 * @ClassName ParmeterOfBall
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/14 22:38
 */

//输入球的中心点和球上某一点的坐标，计算球的半径和体积
public class ParmeterOfBall {
    private static class Point {
        public double x;
        public double y;
        public double z;
        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    private static final double PI = Math.acos(-1);
    private static double distanceOfTwoPoint(Point a, Point b) {
     double x = Math.pow(a.x - b.x, 2);
        double y = Math.pow(a.y - b.y, 2);
        double z = Math.pow(a.z - b.z, 2);
        return Math.sqrt(x + y + z);
    }
    private static double volumeOfSphere(double r) {
        return (4.0 / 3) * PI * Math.pow(r, 3);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();
            Point a = new Point(x0, y0, z0);
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            Point b = new Point(x1, y1, z1);
            double r = distanceOfTwoPoint(a, b);
            double volume = volumeOfSphere(r);
            System.out.format("%.3f %.3f\n", r, volume);
        }
    }
}
