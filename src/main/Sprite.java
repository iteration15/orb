package main;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.*;

import java.util.Random;

/**
 * @author dxw350
 * @version 1.0.0
 * @since 2/8/16
 */
public abstract class Sprite extends Region {

    Vector location;
    Vector velocity;
    Vector acceleration;

    double maxForce = Settings.SPRITE_MAX_FORCE;
    double maxSpeed = Settings.SPRITE_MAX_SPEED;

    Node view;

    // view dimensions
    double width;
    double height;
    double centerX;
    double centerY;
    double centerZ;
    double radius;
    double rate;
    double moons;

    double angle;

    Layer layer = null;

    Image image;

    public Sprite(Image image, Layer layer, Vector location, Vector velocity, Vector acceleration, double width, double height, double rate, double moons) {

        this.image = image;
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.width = width;
        this.height = height;
        this.rate = rate;
        this.moons = moons;

        this.centerX = width / 2;
        this.centerY = height / 2;
        this.centerZ = 0;

        this.view = createView();

        setPrefSize(width, height);

        // add view to this node
        getChildren().add(view);

        // add this node to layer
        layer.getChildren().add(this);

    }

    public abstract Node createView();

    public void applyForce(Vector force) {
        acceleration.add(force);
    }

    public void move() {

        // set velocity depending on acceleration
        velocity.add(acceleration);

        // limit velocity to max speed
        velocity.limit(maxSpeed);

        // change location depending on velocity
        location.add(velocity);

        // angle: towards velocity (ie target)
        //angle = velocity.heading2D();

        // clear acceleration
        acceleration.multiply(0);
    }

    /**
     * Move satellite towards target
     */
    public void seek(Vector target) {

        Vector desired = Vector.subtract(target, location);

        // the distance is the magnitude of the vector pointing from location to target.
        double d = desired.magnitude();
        desired.normalize();

        if (d < Settings.SPRITE_SLOW_DOWN_DISTANCE) {

            double m = 0 + (maxSpeed - 0) * ((d - 0) / (Settings.SPRITE_SLOW_DOWN_DISTANCE - 0));

            desired.multiply(m);


        }
        else {
            desired.multiply(maxSpeed);
        }

        // The usual steering = desired - velocity
        Vector steer = Vector.subtract(desired, velocity);
        steer.limit(maxForce);

        applyForce(steer);
    }

    /**
     * Update node position
     */
    public void display() {

        relocate(location.x - centerX, location.y - centerY);

        setRotate(Math.toDegrees(angle));
    }

    public Vector getVelocity() {
        return velocity;
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(double x, double y, double z) {
        location.x = x;
        location.y = y;
        location.z = z;
    }

    public void setLocationOffset(double x, double y) {
        location.x += x;
        location.y += y;
    }
}

