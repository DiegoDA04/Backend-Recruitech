package pe.edu.notcodingdevs.recruitech.backendrecruitech.security.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.service.UserService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.service.communication.request.LoginRequest;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.service.communication.request.RegisterRequest;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Get JWT token for user")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {
        return userService.authenticate(request);
    }
    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }
}
