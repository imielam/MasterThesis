package com.maciej.imiela.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maciej.imiela.entity.Role;
import com.maciej.imiela.repository.RoleRepository;
import com.maciej.imiela.repository.UserRepository;

@Transactional
@Service
public class InitDBService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private BlogRepository blogRepository;
    //
    // @Autowired
    // private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        this.roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        this.roleRepository.save(roleAdmin);

        // User userAdmin = new User();
        // userAdmin.setName("admin");
        // List<Role> roles = new ArrayList<Role>();
        // roles.add(roleAdmin);
        // roles.add(roleUser);
        // userAdmin.setRoles(roles);
        // this.userRepository.save(userAdmin);
        //
        // Blog blogJavavids = new Blog();
        // blogJavavids.setName("JavaVids");
        // blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        // blogJavavids.setUser(userAdmin);
        // this.blogRepository.save(blogJavavids);
        //
        // Item item1 = new Item();
        // item1.setBlog(blogJavavids);
        // item1.setTitle("first");
        // item1.setLink("http://www.javavids.com");
        // item1.setPublishedDate(new Date());
        // this.itemRepository.save(item1);
        //
        // Item item2 = new Item();
        // item2.setBlog(blogJavavids);
        // item2.setTitle("second");
        // item2.setLink("http://www.javavids.com");
        // item2.setPublishedDate(new Date());
        // this.itemRepository.save(item2);

    }

}
