package ru.interid.instanceconductor.output.python;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Data
@Configuration
@RequiredArgsConstructor
public class PythonProperties {

    private final Environment env;

    public String getDnsCreatorName() {
        return env.getProperty("python-scripts.dns-creator.name");
    }

    public String getDnsCreatorLocation() {
        return env.getProperty("python-scripts.dns-creator.location");
    }

    public String getDockerComposeCreatorName() {
        return env.getProperty("python-scripts.docker-compose-creator.name");
    }

    public String getDockerComposeCreatorLocation() {
        return env.getProperty("python-scripts.docker-compose-creator.location");
    }

    public String getNginxHelperName() {
        return env.getProperty("python-scripts.nginx-helper.name");
    }

    public String getNginxHelperLocation() {
        return env.getProperty("python-scripts.nginx-helper.location");
    }
}
