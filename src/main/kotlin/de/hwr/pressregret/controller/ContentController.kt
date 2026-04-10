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
            title = "About The Game and Inspiration!",
            description = "We are Sara and Emily! We are students at the HWR in Berlin in the 4th semester." +
                    "This is our game 'Press and Regret'. The game was a little inspiration of an other game." +
                    "'Press and Regret' will test your nerves and your reflexes." +
                    "Enjoy the game! If you have anything that we could do better, let us know in the contact section." +
                    "But now, have fun!",
        )
    }

    @GetMapping("/contact")
    fun contact(): ContactResponse {
        return ContactResponse(
            title = "Contact Us",
            description = "You found something we could do better? Or do you want to give some feedback?" +
                    "The contact us via email!",
            email = "s_preissler24@stud.hwr-berlin.de, s_sabra24@stud.hwr-berlin.de"
        )
    }
}

