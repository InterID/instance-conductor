package ru.interid.instanceconductor.output.python;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.dockerComposeManager.NginxHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class PythonNginxHelper implements NginxHelper {

    private final PythonProperties pythonProperties;

    @Override
    public void configureNginx(String prefix, short port) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    pythonProperties.getNginxHelperLocation() + pythonProperties.getNginxHelperName(),
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
