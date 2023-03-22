package ru.interid.instanceconductor.output.python;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.interid.instanceconductor.business.dockerComposeManager.DnsCreator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class PythonDnsCreator implements DnsCreator {

    private final PythonProperties pythonProperties;

    @Override
    public void createDns(String prefix) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", pythonProperties.getDnsCreatorLocation() + pythonProperties.getDnsCreatorName());
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
