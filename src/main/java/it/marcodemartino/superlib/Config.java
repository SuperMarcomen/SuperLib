package it.marcodemartino.superlib;

import it.marcodemartino.superlib.config.SerializableLocation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Config {

    private String pirla = "Default value";
    private SerializableLocation location;

}
