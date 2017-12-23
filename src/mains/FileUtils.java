package mains;
/**
 * The Class FileUtils.
 */
public class FileUtils {
    
    /**
     * Gets the file extension.
     *
     * @param name the name
     * @return the file extension
     */
    public static String getFileExtension(String name) {
        int extIndex = name.lastIndexOf(".");

        if (extIndex == -1) {
            return "";
        } else {
            return name.substring(extIndex + 1);
        }
    }
}
