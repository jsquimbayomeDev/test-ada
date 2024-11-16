package com.ada.prueba.config;

import com.ada.prueba.domain.models.Application;
import com.ada.prueba.domain.models.Version;
import com.ada.prueba.domain.repository.ApplicationRepository;
import com.ada.prueba.domain.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Override
    public void run(String... args) throws Exception {
        Application app = new Application("APP001", "MyApp", "This is a sample application", null);
        applicationRepository.save(app);

        Version version = new Version(app, "1.0.0", "Initial release");
        versionRepository.save(version);

        app.setVersions(List.of(version));
        applicationRepository.save(app);
    }
}
