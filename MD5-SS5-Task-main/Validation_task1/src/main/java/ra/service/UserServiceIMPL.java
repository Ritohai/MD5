package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.model.User;

import ra.repository.IUserRepository;

@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User product) {

    }

    @Override
    public Page<User> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<User> findByFirstName(String name, Pageable pageable) {
        return null;
    }


}
