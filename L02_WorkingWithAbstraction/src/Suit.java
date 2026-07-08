public enum Suit {

    ADMIN(true),
    USER(false),
    SUPPORT(true);

    private boolean isAccessAllowed;


    Suit(boolean isAccessAllowed) {
        this.isAccessAllowed = isAccessAllowed;
    }
}
