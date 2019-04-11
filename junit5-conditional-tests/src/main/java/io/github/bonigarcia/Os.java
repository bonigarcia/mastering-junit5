
package io.github.bonigarcia;

public enum Os {

    WINDOWS, MAC, LINUX, OTHER;

    public static Os determine() {
        Os out = OTHER;

        String myOs = System.getProperty("os.name").toLowerCase();
        if (myOs.contains("win")) {
            out = WINDOWS;
        } else if (myOs.contains("mac")) {
            out = MAC;
        } else if (myOs.contains("nux")) {
            out = LINUX;
        }
        return out;
    }

}
