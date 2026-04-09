package com.HospitalManagement.ManagedHospital.Security;


import com.HospitalManagement.ManagedHospital.dto.LoginRequestDto;
import com.HospitalManagement.ManagedHospital.dto.LoginResponseDto;
import com.HospitalManagement.ManagedHospital.dto.SignupResponseDto;
import com.HospitalManagement.ManagedHospital.entity.User;
import com.HospitalManagement.ManagedHospital.repositry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        User user=(User) authentication.getPrincipal();
    String token=authUtil.generateAccessToken(user);
    System.out.println(token);
    return new LoginResponseDto(token,user.getId());
    }

    public SignupResponseDto signUp(LoginRequestDto signupRequestDto) {
        User user=userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);
        if(user!=null) throw new IllegalArgumentException("User already exits");
        user =userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password( passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );
        return modelMapper.map(user,SignupResponseDto.class);
    }
}
