package de.hwr.pressregret.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/profile")
class ProfileController {

    @GetMapping
    fun getProfile() = "profile"

    @PutMapping
    fun updateProfile() = "profile updated"
}