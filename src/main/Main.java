package main;

import java.io.IOException;
import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author dxw350
 * @version 1.0.0
 * @since 2/8/16
 */
public class Main extends Application {

    static Random random = new Random();

    List<Orb> allOrbs = new ArrayList<>();
    List<Orb> allSatellites = new ArrayList<>();

    AnimationTimer gameLoop;

    Layer field;

    Vector mouseLocation = new Vector(0, 0, 0);

    Scene scene;

    Gestures gestures = new Gestures();

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle(Settings.NAME  + " v" + Settings.VERSION);

        // create containers
        BorderPane borderPane = new BorderPane();

        // field for the Sprites
        field = new Layer(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        // entire field as layers
        Pane layerPane = new Pane();

        layerPane.getChildren().addAll(field);

        borderPane.setCenter(layerPane);

        scene = new Scene(borderPane, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT, Color.BLACK);

        stage.setScene(scene);
        stage.show();

        // add content
        prepareGame();

        // add mouse location listener
        addListeners();

        // run animation loop
        startGame();
    }

    private void prepareGame() {
        // add vehicles
        for(int i = 0; i < Settings.SATELLITE_COUNT; i++) {
            addSatellites();
        }
        // add attractors
        for(int i = 0; i < Settings.ATTRACTOR_COUNT; i++) {
            addOrbs();
        }
    }

    private void startGame() {
        // start game
        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                // currently we have only 1 Orb
                Orb orb = allOrbs.get(0);

                // seek attractor location, apply force to get towards it
                allSatellites.forEach(vehicle -> {
                    vehicle.seek(orb.getLocation());
                });

                // move sprite
                allSatellites.forEach(Sprite::move);

                // update in fx scene
                allSatellites.forEach(Sprite::display);
                allOrbs.forEach(Sprite::display);

            }
        };
        gameLoop.start();
    }

    private void addOrbs() {

        //Layer sunLayer = field;
        //Layer mercuryLayer = field;
        //Layer venusLayer = field;
        Layer earthLayer = field;
        //Layer moonLayer = field;
        Layer marsLayer = field;
        //Layer jupiterLayer = field;
        //Layer saturnLayer = field;
        //Layer uranusLayer = field;
        //Layer neptuneLayer = field;

        // sphere dimensions
        double sunWidth = 300;
        double sunHeight = 300;
        double sunRate = .1;
        double mercuryWidth = 25;
        double mercuryHeight = 25;
        double mercuryRate = 2;
        double venusWidth = 50;
        double venusHeight = 50;
        double venusRate = 3;
        double earthWidth = 300;
        double earthHeight = 300;
        double earthRate = 0.55;
        double moonWidth = 17;
        double moonHeight = 17;
        double moonRate = 2;
        double marsWidth = 150;
        double marsHeight = 150;
        double marsRate = 2;
        double jupiterWidth = 200;
        double jupiterHeight = 200;
        double jupiterRate = 1;
        double saturnWidth = 200;
        double saturnHeight = 200;
        double saturnRate = 1;
        double uranusWidth = 60;
        double uranusHeight = 60;
        double uranusRate = 2;
        double neptuneWidth = 60;
        double neptuneHeight = 60;
        double neptuneRate = 2;

        // create sphere data
        Vector sunLocation = new Vector(250, 350, 0);
        Vector mercuryLocation = new Vector(50, 395, 0);
        Vector venusLocation = new Vector(150, 395, 0);
        Vector earthLocation = new Vector(750, 500, 0);
        Vector moonLocation = new Vector(275, 395, 0);
        Vector marsLocation = new Vector(350, 395, 0);
        Vector jupiterLocation = new Vector(590, 395, 0);
        Vector saturnLocation = new Vector(850, 395, 0);
        Vector uranusLocation = new Vector(950, 395, 0);
        Vector neptuneLocation = new Vector(1050, 395, 0);

        Vector velocity = new Vector(0, 0, 0);
        Vector acceleration = new Vector(0, 0, 0);

        Image sunMap = new Image(getClass().getResourceAsStream("/resources/sunmap.jpg"));
        Image mercuryMap = new Image(getClass().getResourceAsStream("/resources/mercurymap.jpg"));
        Image venusMap = new Image(getClass().getResourceAsStream("/resources/venusmap.jpg"));
        Image earthMap = new Image(getClass().getResourceAsStream(Settings.EARTH_MAP));
        Image moonMap = new Image(getClass().getResourceAsStream("/resources/moonmap.jpg"));
        Image marsMap = new Image(getClass().getResourceAsStream("/resources/marsmap.jpg"));
        Image jupiterMap = new Image(getClass().getResourceAsStream("/resources/jupitermap.jpg"));
        Image saturnMap = new Image(getClass().getResourceAsStream("/resources/saturnmap.jpg"));
        Image uranusMap = new Image(getClass().getResourceAsStream("/resources/uranusmap.jpg"));
        Image neptuneMap = new Image(getClass().getResourceAsStream("/resources/neptunemap.jpg"));

        // create spheres and add to layer
        //Orb sun = new Orb(sunMap, sunLayer, sunLocation, velocity, acceleration, sunWidth, sunHeight, sunRate);
        //Orb mercury = new Orb(mercuryMap, mercuryLayer, mercuryLocation, velocity, acceleration, mercuryWidth, mercuryHeight, mercuryRate);
        //Orb venus = new Orb(venusMap, venusLayer, venusLocation, velocity, acceleration, venusWidth, venusHeight, venusRate);
        Orb earth = new Orb(earthMap, earthLayer, earthLocation, velocity, acceleration, earthWidth, earthHeight, earthRate, 1);
        //Orb moon = new Orb(moonMap, moonLayer, moonLocation, velocity, acceleration, moonWidth, moonHeight, moonRate);
        //Orb mars = new Orb(marsMap, marsLayer, marsLocation, velocity, acceleration, marsWidth, marsHeight, marsRate, 2);
        //Orb jupiter = new Orb(jupiterMap, jupiterLayer, jupiterLocation, velocity, acceleration, jupiterWidth, jupiterHeight, jupiterRate);
        //Orb saturn = new Orb(saturnMap, saturnLayer, saturnLocation, velocity, acceleration, saturnWidth, saturnHeight, saturnRate);
        //Orb uranus = new Orb(uranusMap, uranusLayer, uranusLocation, velocity, acceleration, uranusWidth, uranusHeight, uranusRate);
        //Orb neptune = new Orb(neptuneMap, neptuneLayer, neptuneLocation, velocity, acceleration, neptuneWidth, neptuneHeight, neptuneRate);

        // register spheres
        //allOrbs.add(sun);
        //allOrbs.add(mercury);
        //allOrbs.add(venus);
        allOrbs.add(earth);
        //allOrbs.add(moon);
        //allOrbs.add(mars);
        //allOrbs.add(jupiter);
        //allOrbs.add(saturn);
        //allOrbs.add(uranus);
        //allOrbs.add(neptune);
    }

    private void addSatellites() {

        Layer layer = field;

        Image moonMap = new Image(getClass().getResourceAsStream("/resources/moonmap.jpg"));

        // random location
        double x = random.nextDouble() * layer.getWidth();
        double y = random.nextDouble() * layer.getHeight();
        double z = random.nextDouble() * layer.getHeight();

        // dimensions
        double width = 65;
        double height = 65;
        double rate = 1;

        // create satellite data
        Vector location = new Vector(x, y, z);
        Vector velocity = new Vector(0, 0, 0);
        Vector acceleration = new Vector(0, 0, 0);

        // create sprite and add to layer
        Orb orb = new Orb(moonMap, layer, location, velocity, acceleration, width, height, rate, 0);

        // register satellite
        allSatellites.add(orb);
    }

    private void addListeners() {
        // capture mouse position
        scene.addEventFilter(MouseEvent.ANY, e -> {
            mouseLocation.set(e.getX(), e.getY(), e.getZ());
        });
        // move attractors via mouse
        allOrbs.forEach(gestures::makeDraggable);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
