package ru.interid.instanceconductor.output.python;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.dockerComposeManager.DockerComposeCreator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class PythonDockerComposeCreator implements DockerComposeCreator {

    private final PythonProperties pythonProperties;

    @Override
    public void createDockerCompose(String prefix, short port) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    pythonProperties.getDockerComposeCreatorLocation() + pythonProperties.getDockerComposeCreatorName(),
                    "" + port,
                    prefix);
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
