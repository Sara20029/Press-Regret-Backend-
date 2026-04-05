package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.contentResponse.AboutResponse
import de.hwr.pressregret.api.response.contentResponse.ContactResponse
import de.hwr.pressregret.api.response.contentResponse.HowToPlayResponse
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
            title = "About The Game and Inspiration!",
            description = "We are Sara and Emily!",
        )
    }

    @GetMapping("/contact")
    fun contact(): ContactResponse {
        return ContactResponse(
            title = "Contact Us",
            description = "You found something we could do better? Or do you want to give some feedback?" +
                    "The contact us via email!",
            email = "press.regret@gmail.com"
        )
    }
}

