package trade.mayo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trade.mayo.mapper.local.SysUerMapper;
import trade.mayo.mapper.hengsheng.MfAnnouncementMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@RestController
@Slf4j
public class DbTestController {

    @Autowired
    private MfAnnouncementMapper mfAnnouncementMapper;

    @Autowired
    private SysUerMapper sysUerMapper;

    @RequestMapping(value = "/announcement", method = RequestMethod.POST)
    public Object hello() {
        return mfAnnouncementMapper.getList();
    }

    @Transactional
    @RequestMapping(value = "/inserttest", method = RequestMethod.POST)
    public void insert() {
        Map<String, Object> params = new HashMap<>();
        params.put("username", "aaa");
        params.put("password", "111");
        params.put("job_number", "111");
        params.put("person_name", "111");
        params.put("email", "email");
        params.put("phone", "13854221");
        params.put("create_user", -1);
        params.put("phone", "13854221");
        sysUerMapper.insertUser(params);
    }
}
