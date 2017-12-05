package trade.mayo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Repository
@Mapper
public interface MfAnnouncementMapper {

    //@Select("SELECT * FROM mf_announcement ORDER BY InfoPublDate DESC LIMIT 0,10;")
    public List<Map> getList();
}
