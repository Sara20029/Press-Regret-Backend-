package de.hwr.pressregret.press_regret_backend.content

data class ContentResponse (
    val slug: String,
    val title: String,
    val sections: List<SectionDto>
)

data class SectionDto(
    val heading: String,
    val body: String
)