package picking.entities.places;

import picking.common.ExceptionMessages;
import picking.entities.pickers.Picker;

import java.util.ArrayList;
import java.util.Collection;

public class PlaceImpl implements Place {

    private String name;
    private Collection<String> mushrooms;
    private Collection<Picker> pickers;

    public PlaceImpl(String name) {
        this.name = name;
        this.mushrooms = new ArrayList<>();
        this.pickers = new ArrayList<>();

    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLACE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setMushrooms(Collection<String> mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setPickers(Collection<Picker> pickers) {
        this.pickers = pickers;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<String> getMushrooms() {
        return this.mushrooms;
    }

    @Override
    public Collection<Picker> getPickers() {
        return this.pickers;
    }
}
