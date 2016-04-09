package main;

import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**
 * @author dxw350
 * @version 1.0.0
 * @since 2/8/16
 */
public class Orb extends Sprite {

    public Orb(Image image, Layer layer, Vector location, Vector velocity, Vector acceleration, double width, double height, double rate, double moons) {
        super(image, layer, location, velocity, acceleration, width, height, rate, moons);
    }

    @Override
    public Node createView() {

        double radius = width / 2;

        System.out.println("# of moons: " + moons);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(image);

        Sphere sphere = new Sphere(radius);

        RotateTransition rotate = Vector.rotate(sphere, rate, 360, 0);

        sphere.setMaterial(material);

        rotate.play();

        return sphere;
    }
}
