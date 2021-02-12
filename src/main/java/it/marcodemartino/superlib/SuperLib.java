package it.marcodemartino.superlib;

import it.marcodemartino.superlib.config.SerializableLocation;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

public class SuperLib extends JavaPlugin {

    @SneakyThrows
    @Override
    public void onEnable() {
        Config config = new Config();
        Location location = new Location(Bukkit.getWorld("world"), 0,0,0);
        config.setLocation(new SerializableLocation(location));
        config.setPirla("test");

        /* Save config */
        Yaml yaml = new Yaml();
        FileWriter writer = new FileWriter("plugins/SuperLib/config.yml");
        yaml.dump(config, writer);

        /* Load config */
        File initialFile = new File("plugins/SuperLib/config.yml");
        InputStream targetStream = new FileInputStream(initialFile);
        Config config2 = yaml.loadAs(targetStream, Config.class);
        System.out.println(config2);

    }
}
