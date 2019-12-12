package com.example.exploregreece;

import com.example.exploregreece.features.customer.Customer;
import com.example.exploregreece.features.customer.CustomerRepository;
import com.example.exploregreece.features.customer.Status;
import com.example.exploregreece.features.tour.Tour;
import com.example.exploregreece.features.tour.TourRepository;
import com.example.exploregreece.features.tourPackage.Destination;
import com.example.exploregreece.features.tourPackage.TourPackage;
import com.example.exploregreece.features.tourPackage.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExploregreeceApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TourPackageRepository tourPackageRepository;

    @Autowired
    TourRepository tourRepository;


    public static void main(String[] args) {
        SpringApplication.run(ExploregreeceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

		TourPackage aegeanPackage = new TourPackage("Aegean Tour", "See the Aegean", 600, 8, Destination.AEGEAN);
        TourPackage ionianPackage = new TourPackage("Ionian Tour", "See the Ionian", 600, 8, Destination.IONIAN);
		tourPackageRepository.save(aegeanPackage);
		tourPackageRepository.save(ionianPackage);

        Tour tourNaxos = new Tour("Naxos", "Portara view", 300, 4,aegeanPackage);
        Tour tourMikonos = new Tour("Mikonos", "JackieO", 400, 2,aegeanPackage);
        Tour tourMitilini = new Tour("Mitilini", "stratos", 500, 5,aegeanPackage);
        Tour tourZakynthos = new Tour("Zakinthos", "Tsilivi", 600, 6,ionianPackage);
        Tour tourKefallonia = new Tour("Kefallonia", "Lixouri", 800, 10,ionianPackage);
        tourRepository.save(tourNaxos);
        tourRepository.save(tourMikonos);
        tourRepository.save(tourMitilini);
        tourRepository.save(tourZakynthos);
        tourRepository.save(tourKefallonia);

        Customer george = new Customer("George","Koulis","gkoulis@mail.gr","2101234568", Status.GOLD,3);
        Customer mike = new Customer("Mike","Koulis","mkoulis@mail.gr","2101234568", Status.NEW,1);
        Customer paul = new Customer("Paul","Koulis","pkoulis@mail.gr","2101234568", Status.LOYAL,4);
        Customer denis = new Customer("Denis","Koulis","dkoulis@mail.gr","2101234568", Status.PLATINUM,2);
        customerRepository.save(george);
        customerRepository.save(mike);
        customerRepository.save(paul);
        customerRepository.save(denis);

    }
}
