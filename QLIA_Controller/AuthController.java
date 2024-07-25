package QLIA_Controller;

import QLIA_Service.AuthService;
import QLIA_Service.CustomUserDetailsService;
import QLIA_Service.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import DTO.JwtRequest;
import DTO.JwtResponse;
import DTO.PasswordResetRequest;
import DTO.PasswordResetToken;
import DTO.UserDTO;
import QLIA_Model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDto) {
        return authService.registerUser(userDto);
    }

    @PostMapping("/login")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        final String token = jwtUtil.generateToken(userDetails);
        
        return new JwtResponse(token);
    }

    @PostMapping("/forgot-password")
    public void forgotPassword(@RequestBody PasswordResetRequest passwordResetRequest) {
        authService.sendPasswordResetToken(passwordResetRequest.getEmail());
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestBody PasswordResetToken passwordResetToken) {
        authService.resetPassword(passwordResetToken.getToken(), passwordResetToken.getNewPassword());
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetailsService.getUserByUserName(userDetails.getUsername());
        authService.changePassword(user, oldPassword, newPassword);
    }
}

