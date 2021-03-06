package trade.mayo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trade.mayo.mapper.MfAnnouncementMapper;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@RestController
@Slf4j
public class DbTestController {

    @Autowired
    private MfAnnouncementMapper mfAnnouncementMapper;

    @RequestMapping(value = "/announcement", method = RequestMethod.POST)
    public Object hello() {
        return mfAnnouncementMapper.getList();
    }
}
