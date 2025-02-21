package gigafrosxh.project;

import gigafrosxh.project.graphics.homeUI;
import gigafrosxh.project.util.Logger;

public class SinkShipsMain {
    public static final Logger logger = new Logger();

    public static void main(String[] args) {
        logger.info("Setting up Classes for " + SinkShipsMain.class.getName());
        logger.error("Test Error at " + SinkShipsMain.class.getName());
        logger.warning("Test Warning at " + SinkShipsMain.class.getName());
        homeUI homeUI = new homeUI();
    }
}
