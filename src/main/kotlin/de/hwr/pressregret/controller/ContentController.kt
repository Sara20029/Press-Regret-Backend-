package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.AboutResponse
import de.hwr.pressregret.api.response.HowToPlayResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/content")
class ContentController {

    @GetMapping("/how-to-play")
    fun howToPlay(): HowToPlayResponse {
         return HowToPlayResponse(
            title = "How to play",
            description = "Press the button!",
            instructions = listOf(
                "Press the button in the right moment!",
                "Do not get angry!",
                "read the description on the button!"
            )
        )
    }

    @GetMapping("/about")
    fun about(): AboutResponse {
        return AboutResponse(
            title = "About Us",
            description = "We are Sara and Emily!",
        )
    }
}

