package kr.hs.dgsw.SOPO_server_v2.domain.file.controller;

import kr.hs.dgsw.SOPO_server_v2.domain.file.dto.FileRes;
import kr.hs.dgsw.SOPO_server_v2.domain.file.enums.FileCategory;
import kr.hs.dgsw.SOPO_server_v2.domain.file.service.FileService;
import kr.hs.dgsw.SOPO_server_v2.global.response.ResponseData;
import kr.hs.dgsw.SOPO_server_v2.domain.user.dto.UserRes;
import kr.hs.dgsw.SOPO_server_v2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/logIn")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService; // UserService 추가

    @GetMapping("/id/{id}/pwd/{pwd}")
    public ResponseData<Boolean> validateUser(@PathVariable Long id, @RequestParam String pwd) {
        boolean isValid = userService.validateUser(id, pwd);
        return new ResponseData<>(true, "Validation complete", isValid);
    }
}
