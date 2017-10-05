package net.chrisparton.sparkled;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import net.chrisparton.sparkled.inject.RestApiServerModule;
import net.chrisparton.sparkled.music.inject.MusicPlayerModule;
import net.chrisparton.sparkled.udpserver.inject.UdpServerModule;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(
                new JpaPersistModule("sparkled"),
                new RestApiServerModule(),
                new UdpServerModule(),
                new MusicPlayerModule()
        );

        App app = injector.getInstance(App.class);
        app.start();
    }
}
