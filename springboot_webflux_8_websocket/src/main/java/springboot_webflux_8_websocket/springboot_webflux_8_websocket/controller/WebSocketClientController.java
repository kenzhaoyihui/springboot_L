package springboot_webflux_8_websocket.springboot_webflux_8_websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketClientController {

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String websocketClient() {
        return "client";
    }
}
