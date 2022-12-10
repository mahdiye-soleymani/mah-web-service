package com.mahdiyeh.restfulwebservice.filtering;

import com.mahdiyeh.restfulwebservice.versioning.ActorV1;
import com.mahdiyeh.restfulwebservice.versioning.ActorV2;
import com.mahdiyeh.restfulwebservice.versioning.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorVersioningController {
    @GetMapping("v1/actor")
    public ActorV1 actorV1() {
        return new ActorV1("henry cavil");
    }

    @GetMapping("v2/actor")
    public ActorV2 actorV2() {
        return new ActorV2(new Name("henry", " cavil"));
    }

    @GetMapping(value = "/actor/param", params = "version=1")
    public ActorV1 actorParamV1() {
        return new ActorV1("henry cavil");
    }

    @GetMapping(value = "/actor/param", params = "version=2")
    public ActorV2 actorParamV2() {
        return new ActorV2(new Name("henry", " cavil"));
    }

    @GetMapping(value = "/actor/header", headers = "VERSION=1")
    public ActorV1 actorHeaderV1() {
        return new ActorV1("henry cavil");
    }

    @GetMapping(value = "/actor/header", headers = "VERSION=2")
    public ActorV2 actorHeaderV2() {
        return new ActorV2(new Name("henry", " cavil"));
    }


}
