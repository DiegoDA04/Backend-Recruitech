package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.service;


import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Country;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.CountryRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.LocationRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final CountryRepository countryRepository;

    public LocationServiceImpl(LocationRepository locationRepository, CountryRepository countryRepository) {
        this.locationRepository = locationRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void seed() {

        List<String> countries = List.of("Peru");

        List<String> cities = List.of("Lima","Ica","Tacna","Cajamarca","Cuzco","Ucayali","Ayacucho","Amazonas","Trujillo","Loreto","Arequipa");

        countries.stream().forEach(country -> {
            if(!countryRepository.existsByName(country))
                countryRepository.save(new Country().withName(country));
        });

        cities.stream().forEach(city -> {
            if(!locationRepository.existsByName(city))
                locationRepository.save(new Location()
                        .withCountry(countryRepository.findByName("Peru"))
                        .withName(city)
                );
        });
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location getByName(String name) {
        return locationRepository.getByName(name);
    }


}
