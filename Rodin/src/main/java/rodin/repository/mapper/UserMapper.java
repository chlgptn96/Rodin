package rodin.repository.mapper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import rodin.config.AbstractDao;
import rodin.repository.vo.UserVo;

@Repository("userMapper")
public class UserMapper extends AbstractDao {
	private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);
	
	public int insertUser(UserVo uvo) {
        int insertedCount = 0;
        logger.debug("uvo: " + uvo);
        insertedCount = (int) insert("user.insertUser", uvo);
        logger.debug("Join Method Called in UserMapper");

        return insertedCount;
    }

    public UserVo selectUserByEmailAndPasswordAtMapper(String email, String password) {
        logger.debug("Query Called At MapperMethod");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("email", email);
        userMap.put("password", password);
        logger.debug(userMap + " - Mapper");
        return (UserVo) selectOne("user.selectUserByEmailAndPassword", userMap);
    }
}
