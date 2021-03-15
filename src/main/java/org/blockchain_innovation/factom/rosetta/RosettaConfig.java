package org.blockchain_innovation.factom.rosetta;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "factom.rosetta")
@Data
public class RosettaConfig {

    private Fct fct = new Fct();
    private Ec ec = new Ec();
    private Data data = new Data();

    @lombok.Data
    public static class Fct {

        private boolean enabled = true;
    }

    @lombok.Data
    public static class Ec {

        private boolean enabled = false;
    }

    @lombok.Data
    public static class Data {

        private Entries entries = new Entries();

        @Getter
        public static class Entries {

            private boolean enabled = false;
        }
    }

}
