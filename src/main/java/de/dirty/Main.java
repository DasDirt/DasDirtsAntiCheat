package de.dirty;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 13:42
 */
public class Main extends JavaPlugin {

    private Logger logger = getLogger();
    private String PREFIX = "DDAC";
    private String VERSION = "1.0";

    @Override
    public void onEnable() {
        drawLogo();
        logger.info(PREFIX + "{" + VERSION + "} now loading");
        logger.warning("This plugin is still in beta it could come to errors");
        logger.info("An anticheat is not a 100% guarantee to avoid hackers but it makes hacking difficult\n");
        super.onEnable();
    }

    private void drawLogo() {
        logger.info("\n" +
                "                                                                                    \n" +
                "DDDDDDDDDDDDD      DDDDDDDDDDDDD                  AAA                  CCCCCCCCCCCCC\n" +
                "D::::::::::::DDD   D::::::::::::DDD              A:::A              CCC::::::::::::C\n" +
                "D:::::::::::::::DD D:::::::::::::::DD           A:::::A           CC:::::::::::::::C\n" +
                "DDD:::::DDDDD:::::DDDD:::::DDDDD:::::D         A:::::::A         C:::::CCCCCCCC::::C\n" +
                "  D:::::D    D:::::D D:::::D    D:::::D       A:::::::::A       C:::::C       CCCCCC\n" +
                "  D:::::D     D:::::DD:::::D     D:::::D     A:::::A:::::A     C:::::C              \n" +
                "  D:::::D     D:::::DD:::::D     D:::::D    A:::::A A:::::A    C:::::C              \n" +
                "  D:::::D     D:::::DD:::::D     D:::::D   A:::::A   A:::::A   C:::::C              \n" +
                "  D:::::D     D:::::DD:::::D     D:::::D  A:::::A     A:::::A  C:::::C              \n" +
                "  D:::::D     D:::::DD:::::D     D:::::D A:::::AAAAAAAAA:::::A C:::::C              \n" +
                "  D:::::D     D:::::DD:::::D     D:::::DA:::::::::::::::::::::AC:::::C              \n" +
                "  D:::::D    D:::::D D:::::D    D:::::DA:::::AAAAAAAAAAAAA:::::AC:::::C       CCCCCC\n" +
                "DDD:::::DDDDD:::::DDDD:::::DDDDD:::::DA:::::A             A:::::AC:::::CCCCCCCC::::C\n" +
                "D:::::::::::::::DD D:::::::::::::::DDA:::::A               A:::::ACC:::::::::::::::C\n" +
                "D::::::::::::DDD   D::::::::::::DDD A:::::A                 A:::::A CCC::::::::::::C\n" +
                "DDDDDDDDDDDDD      DDDDDDDDDDDDD   AAAAAAA                   AAAAAAA   CCCCCCCCCCCCC\n" +
                "                                                                                    \n");
    }

    @Override
    public void onDisable() {
        drawLogo();
        logger.info("The plugin " + PREFIX + "{" + VERSION + "} has been shut down");
        super.onDisable();
    }
}
