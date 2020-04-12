package tech.donau;

import io.quarkus.vault.VaultKVSecretEngine;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    @Inject
    VaultKVSecretEngine engine;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return engine.readSecret("myapps/quarkus/config").get("adminpass");
    }
}