package trade.mayo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Repository
public interface MfAnnouncementMapper {
    public List<Map> getList();
}
