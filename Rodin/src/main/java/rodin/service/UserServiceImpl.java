package rodin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rodin.repository.mapper.UserMapper;
import rodin.repository.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean setUser(UserVo uvo) {
		uvo.setVisit(1L);
        int insertedCount = userMapper.insertUser(uvo);
        logger.debug("Join Method Called in UserService");
        
        return 1 == insertedCount;
	}

	@Override
	public UserVo getUserByEmailAndPasswordAtService(String email, String password) {
        logger.debug("UserSelectedByEmailAndPassword Called Using UserMapper");
        logger.debug("id:" + email + " - Service");
        logger.debug(("pw:" + password + " - Service"));
        UserVo user = userMapper.selectUserByEmailAndPasswordAtMapper(email, password);
        logger.debug("Reverse");
        if (user != null) {
            logger.debug("id : " + user.getEmail());
            logger.debug("pw : " + user.getPassword());
            logger.debug("name: " + user.getName());
            user.setVisit(user.getVisit() + 1);
            logger.debug("visited : " + user.getVisit());
        } else {
            logger.debug("user : null");
        }

        logger.debug("UserSelectedByEmailAndPassword in UserService : " + user);
        return user;
	}
	
	
}
