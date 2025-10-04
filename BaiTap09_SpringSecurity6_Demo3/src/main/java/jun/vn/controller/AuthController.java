package jun.vn.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import jun.vn.entity.Role;
import jun.vn.entity.Users;
import jun.vn.model.Login;
import jun.vn.model.SignUp;
import jun.vn.repository.RoleRepository;
import jun.vn.repository.UserRepository;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  RoleRepository roleRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody Login loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!", HttpStatus.OK);
    }
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUp signUpDto) {

        // kiem tra da co username chua
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // kiem tra da co email chua
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // tạo user
        Users user = new Users();
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setEnabled(true);
		// set role
        Role roleUser = roleRepository.findByName("USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "USER")));

        user.setRoles(Collections.singleton(roleUser));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}