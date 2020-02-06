package rodin.service;

import rodin.repository.vo.UserVo;

public interface UserService {
	boolean setUser(UserVo uvo);
	UserVo getUserByEmailAndPasswordAtService(String email, String password);
    // UserVo getUserByIdAtService(String id);
}
