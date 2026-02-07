package de.hwr.pressregret.press_regret_backend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun test() = "Hello World!"
}