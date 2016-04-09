package main;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.shape.Sphere;

/**
 * @author dxw350
 * @version 1.0.0
 * @since 2/8/16
 */
public class Vector {

    public double x;
    public double y;
    public double z = 0;


    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double magnitude() {
        return (double) Math.sqrt(x * x + y * y);
    }

    public void add(Vector v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void multiply(double n) {
        x *= n;
        y *= n;
        z *= n;
    }

    public void div(double n) {
        x /= n;
        y /= n;
    }

    public void normalize() {
        double m = magnitude();
        if (m != 0 && m != 1) {
            div(m);
        }
    }

    public void limit(double max) {
        if (magnitude() > max) {
            normalize();
            multiply(max);
        }
    }

    static public RotateTransition rotate(Sphere sphere, double rate, double fromAngle, double toAngle) {

        RotateTransition rotate = new RotateTransition(Duration.seconds(30), sphere);

        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setFromAngle(fromAngle);
        rotate.setToAngle(toAngle);
        rotate.setRate(rate);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(RotateTransition.INDEFINITE);

        return rotate;
    }

    static public Vector subtract(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public double heading2D() {
        return Math.atan2(y, x);
    }
}

