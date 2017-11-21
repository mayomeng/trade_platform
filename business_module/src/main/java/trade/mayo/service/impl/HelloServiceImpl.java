package trade.mayo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.mayo.dao.HelloDao;
import trade.mayo.service.HelloService;

/**
 * Created by Administrator on 2017/6/2.
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public String sayHello(String name) {
        helloDao.setUserName("userName", name);
        return helloDao.getUserName("userName");
    }
}
