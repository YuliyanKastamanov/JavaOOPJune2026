package Military;

public class MissionImpl implements Mission {

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }



    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public void completeMission() {

    }
}
