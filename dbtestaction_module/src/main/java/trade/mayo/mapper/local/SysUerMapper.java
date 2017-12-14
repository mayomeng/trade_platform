package trade.mayo.mapper.local;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/13 0013.
 */
@Repository
@Mapper
public interface SysUerMapper {
    public int insertUser(Map<String, Object> user);
}
