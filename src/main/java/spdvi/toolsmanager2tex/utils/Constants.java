
package spdvi.toolsmanager2tex.utils;

/**
 *
 * @author Miguel
 */
public class Constants {
    public static final int DEFAULT_PROFILE_IMAGE_WIDTH = 250;
    public static final int DEFAULT_PROFILE_IMAGE_HEIGHT = 250;
    public static final String DEFAULT_PROFILE_IMAGE_TYPE = "png";
    public static final int MAX_IMAGE_FILE_SIZE = 1000000;
    public static String UsersPath = System.getProperty("user.home") +("\\AppData\\Local\\ToolsManager\\data\\Usuaris.csv");
    public static String LevelsPath = System.getProperty("user.home") +("\\AppData\\Local\\ToolsManager\\data\\ConfiguracioNivells.csv");
    public static String ToolsPath = System.getProperty("user.home") +("\\AppData\\Local\\ToolsManager\\data\\Tools.csv");
}
