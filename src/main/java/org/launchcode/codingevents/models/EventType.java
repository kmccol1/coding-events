package org.launchcode.codingevents.models;

public enum EventType
{
    CONFERENCE("Conference"),
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
//    SOCIAL("Social"),
//    SEMINAR("Seminar"),
//    GALA("Gala"),
//    DISCUSSION("Discussion"),
//    MEETING("Meeting"),
//    ROUNDTABLE("Roundtable"),
//    ALLHANDS("Allhands"),
//    CONVERSATION("Conversation"),
//    LECTURE("Lecture"),
//    BALL("Ball"),
//    FIESTA("Fiesta"),
//    FESTIVAL("Festival"),
//    SESSION("Session"),
//    STANDUP("Standup"),
//    DEBRIEF("Debrief"),
//    CONVENTION("Convention"),
//    CLASS("Class"),
//    GATHERING("Gathering"),
//    FORUM("Forum"),
//    ASSEMBLY("Assembly"),
//    CAUCUS("Caucus"),
//    PARTY("Party"),
//    FUNCTION("Function"),
//    JAMBOREE("Jamboree"),
//    REUNION("Reunion"),
//    GAME("Game"),
//    CELEBRATION("Celebration"),
    MOVEMENT("Movement");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
