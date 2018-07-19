package library.library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

//@Service
//@EnableConfigurationProperties(ServiceProperties.class)
//public class MyService {
//
//    private final ServiceProperties serviceProperties;
//
//    public MyService(ServiceProperties serviceProperties) {
//        this.serviceProperties = serviceProperties;
//    }
//
//    public String message() {
//        return this.serviceProperties.getMessage();
//    }
//}


@Component
public class MyService {
    private final String message;

    public MyService(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}

