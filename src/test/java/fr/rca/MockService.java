package fr.rca;

import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Mock
@ApplicationScoped
public class MockService extends EvenementService {

    @Override
    public List<Evenement> getEvenements(){
        return new ArrayList<>();
    }
}
