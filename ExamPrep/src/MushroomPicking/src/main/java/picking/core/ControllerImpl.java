package picking.core;

import picking.common.ConstantMessages;
import picking.common.ExceptionMessages;
import picking.entities.action.Action;
import picking.entities.action.ActionImpl;
import picking.entities.pickers.ExperiencedPicker;
import picking.entities.pickers.JuniorPicker;
import picking.entities.pickers.Picker;
import picking.entities.places.Place;
import picking.entities.places.PlaceImpl;
import picking.repositories.PlaceRepository;
import picking.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static picking.common.ConstantMessages.PLACE_ADDED;

//TODO - Implement all the methods
public class ControllerImpl implements Controller {


    private final Repository<Place> placeRepository;

    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
    }


    @Override
    public String addPlace(String placeName, String... mushrooms) {

        Place place = new PlaceImpl(placeName);
        place.getMushrooms().addAll(List.of(mushrooms));

        this.placeRepository.add(place);
        return String.format(PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        Place place = placeRepository.byName(placeName);

        Picker pikerByName = place.getPickers().stream()
                .filter(piker -> piker.getName().equals(pickerName))
                .findFirst()
                .orElse(null);

        if(pikerByName != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PICKER);
        }

        Picker picker = switch (pickerType){
            case "JuniorPicker" ->  new JuniorPicker(pickerName);
            case "ExperiencedPicker" -> new ExperiencedPicker(pickerName);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PICKER);
        };
        /*Picker picker = null;

        switch (pickerType){
            case "JuniorPicker" -> picker = new JuniorPicker(pickerName);
            case "ExperiencedPicker" -> picker = new ExperiencedPicker(pickerName);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PICKER);
        }*/

        place.getPickers().add(picker);
        return String.format(ConstantMessages.PICKER_ADDED, pickerType, pickerName);
    }

    @Override
    public String startPicking(String placeName) {

        //извикраме метода startPicking -> ActionImpl
        Place place = this.placeRepository.byName(placeName);

        if (place == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_PLACE, placeName));
        }
        Action action = new ActionImpl();
        action.startPicking(place);
        return String.format(ConstantMessages.PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        Collection<Place> places = placeRepository.getCollection();

        for (Place place : places){
            builder.append(String.format("Pickers in the %s:", place.getName()))
                    .append(System.lineSeparator());

            for (Picker picker : place.getPickers()){
                Collection<String> pikerMushrooms = picker.getBag().getMushrooms();

                builder.append(String.format("Name: %s%n", picker.getName()))
                        .append(String.format("Vitality: %d%n", picker.getVitality()))
                        .append(String.format("Bag mushrooms: %s%n",
                                !pikerMushrooms.isEmpty() ? String.join(", ", pikerMushrooms) : "none"));
            }

        }

        return builder.toString();
    }
}
