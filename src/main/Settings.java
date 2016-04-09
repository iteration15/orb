package main;

/**
 * @author dxw350
 * @version 1.0.0
 * @since 2/8/16
 */
public class Settings {

    public static final String NAME = "Orb";

    public static final String VERSION = "1.0.0.1";

    public static double SCENE_WIDTH = 1280;
    public static double SCENE_HEIGHT = 720;

    public static int ATTRACTOR_COUNT = 1;
    public static int SATELLITE_COUNT = 1;

    public static double SPRITE_MAX_SPEED = 1;
    public static double SPRITE_MAX_FORCE = 1;

    // distance at which the satellite moves slower towards the target
    public static double SPRITE_SLOW_DOWN_DISTANCE = 200;

    public static final String EARTH_MAP = "/resources/earthmap.jpg";
}
