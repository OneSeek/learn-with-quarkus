package cn.oneseek.quarkus.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.oneseek.quarkus.service.GreetingService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello") // @Path，标注资源类或者方法的相对路径
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET // @GET，@PUT，@POST，@DELETE，标注方法是HTTP请求的类型。
    @Produces(MediaType.TEXT_PLAIN) //@Produces，标注返回的MIME媒体类型
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
