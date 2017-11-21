package trade.mayo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trade.mayo.info.HelloInfo;

/**
 * Created by Administrator on 2017/6/12.
 */
@RestController
@Slf4j
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="username") String username,
                        @RequestParam(value="password") String password) {
        log.info("login");
        return "login";
    }
}
