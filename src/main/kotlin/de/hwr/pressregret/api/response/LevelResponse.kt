package de.hwr.pressregret.api.response

import javax.xml.stream.events.ProcessingInstruction

data class LevelResponse(
    val id: Int,
    val difficulty: Int,
    val number: String,
    val instruction: String,

)