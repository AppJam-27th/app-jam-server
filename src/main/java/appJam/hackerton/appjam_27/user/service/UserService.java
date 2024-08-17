package appJam.hackerton.appjam_27.user.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean validateUser(Long id, String pwd) {
        return userRepository.findByIdAndUserPwd(id, pwd).isPresent();
    }
}
