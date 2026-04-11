package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.contentResponse.AboutResponse
import de.hwr.pressregret.api.response.contentResponse.ContactResponse
import de.hwr.pressregret.api.response.contentResponse.HowToPlayResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/content")
class ContentController {

    @GetMapping("/how-to-play")
    fun howToPlay(): HowToPlayResponse {
         return HowToPlayResponse(
            title = "howToPlay.title",
            description = "howToPlay.description",
            instructions = listOf(
                "howToPlay.instructions.0",
                "howToPlay.instructions.1",
                "howToPlay.instructions.2",
                "howToPlay.instructions.3",
                "howToPlay.instructions.4",
                "howToPlay.instructions.5",
                "howToPlay.instructions.6",
                "howToPlay.instructions.7",
                "howToPlay.instructions.8"
            )
        )
    }

    @GetMapping("/about")
    fun about(): AboutResponse {
        return AboutResponse(
            title = "about.title",
            description = "about.description",
        )
    }

    @GetMapping("/contact")
    fun contact(): ContactResponse {
        return ContactResponse(
            title = "contact.title",
            description = "contact.description",
            email = "s_preissler24@stud.hwr-berlin.de, s_sabra24@stud.hwr-berlin.de"
        )
    }
}

