package com.example.myblog.business.concretes;

import com.example.myblog.business.abstracts.UserService;
import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.core.utilities.results.SuccessDataResult;
import com.example.myblog.core.utilities.results.SuccessResult;
import com.example.myblog.dataAccess.abstracts.RoleDao;
import com.example.myblog.dataAccess.abstracts.StoryDao;
import com.example.myblog.dataAccess.abstracts.UserDao;
import com.example.myblog.entities.concretes.Role;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserManager implements UserService, UserDetailsService {
    private UserDao userDao;
    private RoleDao roleDao;
    private StoryDao storyDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserDao userDao, RoleDao roleDao, StoryDao storyDao,PasswordEncoder passwordEncoder){
        super();
        this.roleDao=roleDao;
        this.userDao=userDao;
        this.storyDao=storyDao;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public Result add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userDao.save(user);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult("Başarılı");
    }

    @Override
    public Result delete(User user) {
        this.userDao.delete(user);

        return new SuccessResult("Başarılı");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Getirildi");
    }

    @Override
    public DataResult<User> getUserById(Long id) {
        return new SuccessDataResult<User>(this.userDao.getById(id));
    }

    @Override
    public DataResult<User> getUserByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email));
    }

    @Override
    public DataResult<User> getUserByUsername(String username) {
        return new SuccessDataResult<User>(this.userDao.findByUsername(username));
    }

    @Override
    public DataResult<Role> saveRole(Role role) {
        return new SuccessDataResult<Role>(this.roleDao.save(role));
    }

    @Override
    public Result addStoryToUser(Long userId, Long storyId) {
        User user=this.userDao.getById(userId);
        Story story=this.storyDao.getById(storyId);
        story.setUser(user);
        this.userDao.save(user);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result addRoleToUser(String username, String roleName) {
        var user=this.userDao.findByUsername(username);
        var role=this.roleDao.findByName(roleName);
        user.getRoles().add(role);
        return new SuccessResult("Rol ekleme başarılı");
    }

    @Override
    public Result deleteAllUser() {
        this.userDao.deleteAll();
        this.roleDao.deleteAll();
        return new SuccessResult("");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user= this.userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User nor found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
