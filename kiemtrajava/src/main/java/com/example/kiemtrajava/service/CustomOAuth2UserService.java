package com.example.kiemtrajava.service;


import com.example.kiemtrajava.Role;
import com.example.kiemtrajava.model.User;
import com.example.kiemtrajava.repository.IRoleRepository;
import com.example.kiemtrajava.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oauth2User = delegate.loadUser(userRequest);

        // Custom logic to map OAuth2 user attributes and authorities
        String providerName = userRequest.getClientRegistration().getRegistrationId();
        String email = oauth2User.getAttribute("email");

        // Check if the user exists in your database
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    // Create a new user if not found
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setPassword(""); // Set a default password or generate one
                    newUser.setRoles(Collections.singleton(roleRepository.findRoleById(Role.USER.value))); // Set default role to USER
                    userRepository.save(newUser);
                    return newUser;
                });

        return oauth2User;
    }
}
