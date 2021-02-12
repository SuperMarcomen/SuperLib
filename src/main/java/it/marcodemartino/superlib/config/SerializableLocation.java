package it.marcodemartino.superlib.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SerializableLocation {

    private Location serializedLocation;

    public SerializableLocation(Location location) {
        this.serializedLocation = location;
    }

    public String getSerializedLocation() {
        return serialize(serializedLocation);
    }

    public void setSerializedLocation(String serializedLocation) {
        this.serializedLocation = deserialize(serializedLocation);
    }

    public Location get() {
        return serializedLocation;
    }

    public void set(Location location) {
        this.serializedLocation = location;
    }

    public static String serialize(Location location) {
        if(location == null)
            return null;

        return location.getWorld().getName() + ":" +
                location.getX() + ":" +
                location.getY() + ":" +
                location.getZ() + ":" +
                location.getYaw() + ":" +
                location.getPitch();
    }

    public static Location deserialize(String serializedLocation) {
        if(serializedLocation == null || serializedLocation.isEmpty())
            return null;

        String[] split = serializedLocation.split(":");

        if(split.length < 6)
            return null;

        return new Location(
                Bukkit.getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                Float.parseFloat(split[4]),
                Float.parseFloat(split[5])
        );
    }
}
