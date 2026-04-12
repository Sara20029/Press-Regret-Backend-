package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.contentResponse.AboutResponse
import de.hwr.pressregret.api.response.contentResponse.ContactResponse
import de.hwr.pressregret.api.response.contentResponse.HowToPlayResponse
import org.springframework.web.bind.annotation.*

/**
 * Controller for serving static content pages.
 * Content uses i18n keys resolved on the frontend.
 */
@RestController
@RequestMapping("/api/content")
class ContentController {

    // Returns the how-to-play content with a list of instruction i18n keys
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

    // Returns the about page content
    @GetMapping("/about")
    fun about(): AboutResponse {
        return AboutResponse(
            title = "about.title",
            description = "about.description",
        )
    }

    // Returns the contact page content including team mail address.
    @GetMapping("/contact")
    fun contact(): ContactResponse {
        return ContactResponse(
            title = "contact.title",
            description = "contact.description",
            email = "s_preissler24@stud.hwr-berlin.de, s_sabra24@stud.hwr-berlin.de"
        )
    }
}

