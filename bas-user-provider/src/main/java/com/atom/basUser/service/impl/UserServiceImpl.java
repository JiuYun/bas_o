package com.atom.basUser.service.impl;

        import com.atom.basUser.entity.TbUsersEntity;
        import com.atom.basUser.mapper.TbUsersEntityMapper;
        import com.atom.basUser.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

/***
 * 用户相关服务实现
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUsersEntityMapper usersEntityMapper;

    public List<TbUsersEntity> userList() {

        return usersEntityMapper.selectAll("12");
    }
}
