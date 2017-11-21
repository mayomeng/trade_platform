package trade.mayo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trade.mayo.info.HelloInfo;
import trade.mayo.messageQueue.MessageTemplate;
import trade.mayo.service.HelloService;

/**
 * Created by Administrator on 2017/6/2.
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    private MessageTemplate messageTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public HelloInfo hello(@RequestBody HelloInfo info) {
        String value = helloService.sayHello(info.getName());
        log.info(value);
        messageTemplate.send("testtopic2", String.valueOf(info.getId()), info.getName());
        return info;
    }
}
